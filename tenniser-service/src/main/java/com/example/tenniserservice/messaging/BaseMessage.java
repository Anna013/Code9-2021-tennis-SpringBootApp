package com.example.tenniserservice.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Setter
@Getter
@SuperBuilder
public abstract class BaseMessage {

    @JsonProperty("version")
    public long version;

    @JsonProperty("sending_time")
    public String sendingTime;
}

