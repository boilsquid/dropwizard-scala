package com.example.helloworld.resources

import com.example.helloworld.core.Saying
import com.codahale.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong

import com.google.common.base.Optional

@Path("/hello-world")
@Produces(Array(MediaType.APPLICATION_JSON))
class HelloWorldResource(template: String, defaultName: String){

  val counter: AtomicLong = new AtomicLong

  @GET
  @Timed
  def sayHello(@QueryParam("name") name: Optional[String]): Saying = {
    val value = String.format(template, name.or(defaultName))
    new Saying(counter.incrementAndGet(), value)
  }
}
