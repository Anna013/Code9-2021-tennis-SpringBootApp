package com.example.tenniserservice.tenniser;


import com.example.tenniserservice.exception.AlreadyExistsException;
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
        } else {
            throw new AlreadyExistsException(String.format("Tenniser with email '%s' already exists", tenniser.getEmail()));
        }
    }

    public void deleteTenniser(Integer id){
        tenniserRepository.deleteByIdTenniser(id);
    }

    public Tenniser getTenniser(Integer id){
            return tenniserRepository.findByIdTenniser(id);
    }

    public void updateTenniser(Tenniser t) {
        Tenniser existingTenniser = tenniserRepository.findByEmail(t.getEmail());
        if (existingTenniser != null) {
            Tenniser updatedTenniser = Tenniser.builder()
                    .idTenniser(existingTenniser.getIdTenniser())
                    .email(existingTenniser.getEmail())
                    .firstName(existingTenniser.getFirstName())
                    .lastName(existingTenniser.getLastName())
                    .isPaid(true)
                    .methodOfPayment(t.getMethodOfPayment())
                    .build();
            tenniserRepository.save(updatedTenniser);
        } else {
            throw new AlreadyExistsException(String.format("Tenniser with email '%s' already exists", t.getEmail()));
        }
    }


}
