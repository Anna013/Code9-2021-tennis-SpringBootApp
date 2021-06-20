package com.example.tenniserservice.tenniser;

import com.example.tenniserservice.tenniser.client.TenniserClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value="api/tennisers")
public class TenniserController implements TenniserClient {

    private final TenniserService tenniserService;

    @GetMapping
    public List<Tenniser> getAll() {
        return new ArrayList<>(tenniserService.findAll());
    }

    @PostMapping
    public void createTenniser(@RequestBody final Tenniser t) {
        tenniserService.createTenniser(t);
    }

    @DeleteMapping("/{id}")
    public void deleteTenniser(@PathVariable("id") final Integer id) {
        tenniserService.deleteTenniser(id);
    }

    @PutMapping
    public void updateTenniser(@RequestBody final Tenniser update) {
        tenniserService.updateTenniser(update);
    }

    @Override
    @GetMapping("{id}")
    public Tenniser getTenniser(@PathVariable("id") Integer id){
        return tenniserService.getTenniser(id);
    }


}

