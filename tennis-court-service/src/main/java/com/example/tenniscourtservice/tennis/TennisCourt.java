package com.example.tenniscourtservice.tennis;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tennis_court")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@NamedQuery(name="TennisCourt.findAll", query="SELECT t FROM TennisCourt t")
public class TennisCourt {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_court")
    private int idCourt;

    private String name;

    //bi-directional many-to-one association to Timeslot
    @OneToMany(mappedBy="tennisCourt")
    private List<Timeslot> timeslots;


}