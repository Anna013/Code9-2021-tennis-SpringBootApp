package com.example.tenniscourtservice.tennis;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisCourtRepository extends JpaRepository<TennisCourt, Integer> {

    boolean existsByName(String name);

    void deleteByName(String name);

    TennisCourt findByName(String name);

}
