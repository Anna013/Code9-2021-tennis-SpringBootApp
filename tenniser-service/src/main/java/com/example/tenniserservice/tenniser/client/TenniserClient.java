package com.example.tenniserservice.tenniser.client;

import com.example.tenniserservice.tenniser.Tenniser;
import feign.RequestLine;

import java.util.List;

//@FeignClient(name = "tennis-court-service")
public interface TenniserClient {

    //primer
    @RequestLine("GET /api/tennisers")
    List<Tenniser> getAll();
}
