package com.example.helloworld.health

import com.codahale.metrics.health.HealthCheck

class TemplateHealthCheck(private val template: String) extends HealthCheck{

  protected override def check(): HealthCheck.Result = {
    HealthCheck.Result.healthy()
  }

}
