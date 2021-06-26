package com.example.tenniscourtservice.tennis;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/tennis-courts")
@AllArgsConstructor
public class TennisCourtController {

    private final TennisCourtService tennisCourtService;

    @GetMapping
    public List<TennisCourt> getAll() {
        return new ArrayList<>(tennisCourtService.findAll());
    }


    @GetMapping("/{name}")
    public TennisCourt getOne(@PathVariable("name") String name) {
        return tennisCourtService.findOneByName(name);
    }

    @PostMapping
    public void createTennisCourt(@RequestBody final TennisCourt tc) {
        tennisCourtService.createTennisCourt(tc);
    }

    @DeleteMapping("/{name}")
    public void deleteTennisCourt(@PathVariable("name") final String name) {
        tennisCourtService.deleteTennisCourt(name);
    }

    //Timeslot

    @PostMapping("/reserve/{name}")
    public void reserveTimeslot(@RequestBody final Timeslot ts, @PathVariable("name") String courtName){
        tennisCourtService.reserveTimeslot(ts, courtName);
    }

    @DeleteMapping("/{id}")
    public void deleteTennisCourt(@PathVariable("id") final Integer id) {
        tennisCourtService.deleteTimeslot(id);
    }




}
