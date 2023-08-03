package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;


@Introspected
public record Item(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id, String name, long value)
{

}
