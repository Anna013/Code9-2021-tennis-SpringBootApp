package com.example.tenniserservice.tenniser;


import com.example.tenniserservice.exception.AlreadyExistsException;
import com.example.tenniserservice.tenniser.client.TenniserClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TenniserService {

    public final TenniserRepository tenniserRepository;


    public List<Tenniser> findAll(){
        return tenniserRepository.findAll();
    }

    public void createTenniser(Tenniser tenniser) {
        if (!tenniserRepository.existsByEmail(tenniser.getEmail())) {
            tenniserRepository.save(tenniser);
            //publishMessageIfSubscribed(tenniser, UserOperation.CREATE);
        } else {
            throw new AlreadyExistsException(String.format("Tenniser with email '%s' already exists", tenniser.getEmail()));
        }
    }


    public void deleteTenniser(Integer id){
        tenniserRepository.deleteByIdTenniser(id);
    }



}
