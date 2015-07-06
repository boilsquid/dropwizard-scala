package com.example.helloworld.core

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

case class Saying(@JsonProperty id: Long, @JsonProperty @Length(max = 3) content: String)
