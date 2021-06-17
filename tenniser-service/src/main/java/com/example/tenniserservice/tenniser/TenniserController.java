package com.example.tenniserservice.tenniser;

import com.example.tenniserservice.tenniser.client.TenniserClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value="api/tennisers")
public class TenniserController implements TenniserClient {

    private final TenniserService tenniserService;

    @Override
    @GetMapping
    public List<Tenniser> getAll() {
        return new ArrayList<>(tenniserService.findAll());
    }

    @PostMapping
    public void createUser(@RequestBody Tenniser t) {
        tenniserService.createTenniser(t);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") final Integer id) {
        tenniserService.deleteTenniser(id);
    }


}

