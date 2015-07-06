package com.example.helloworld

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty

case class HelloWorldConfiguration(@NotEmpty @JsonProperty template: String, @NotEmpty @JsonProperty defaultName: String = "Stranger") extends Configuration

