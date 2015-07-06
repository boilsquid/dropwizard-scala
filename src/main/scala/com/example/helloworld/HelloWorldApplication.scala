package com.example.helloworld

import com.example.helloworld.health.TemplateHealthCheck
import com.example.helloworld.resources.HelloWorldResource
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import io.dropwizard.{Bundle, Application}
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class HelloWorldApplication extends Application[HelloWorldConfiguration]{

  override def initialize(bootstrap: Bootstrap[HelloWorldConfiguration]) {
    bootstrap.addBundle(new ScalaBundle)
  }

  override def getName: String = {
    "Hello World"
  }

  override def run(config: HelloWorldConfiguration, environment: Environment): Unit = {
    val resource: HelloWorldResource = new HelloWorldResource(config.template, config.defaultName)
    environment.jersey().register(resource)
    val healthCheck: TemplateHealthCheck = new TemplateHealthCheck(config.template)
    environment.healthChecks().register("template", healthCheck)
  }

}

object HelloApplication extends HelloWorldApplication {
  final def main(args: Array[String]) {
    run(args:_*)
  }
}

class ScalaBundle extends Bundle {
  def initialize(bootstrap: Bootstrap[_]) {
    bootstrap.getObjectMapper.registerModule(DefaultScalaModule)
  }

  def run(environment: Environment) {

  }
}
