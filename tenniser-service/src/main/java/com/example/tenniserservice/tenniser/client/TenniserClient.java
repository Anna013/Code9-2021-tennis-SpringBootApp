package com.example.tenniserservice.tenniser.client;

import com.example.tenniserservice.tenniser.Tenniser;
import feign.RequestLine;

import java.util.List;

public interface TenniserClient {


    @RequestLine("GET /api/tennisers")
    Tenniser getTenniser(Integer id);
}
