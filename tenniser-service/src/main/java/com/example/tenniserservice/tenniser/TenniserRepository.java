package com.example.tenniserservice.tenniser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenniserRepository extends JpaRepository<Tenniser, Long> {

    boolean existsByEmail(String email);

    void deleteByIdTenniser(Integer id);

    Tenniser findByIdTenniser(Integer id);

     Tenniser findByEmail(String email);


}
