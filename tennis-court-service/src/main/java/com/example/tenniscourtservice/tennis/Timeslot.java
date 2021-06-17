package com.example.tenniscourtservice.tennis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Table(name="timeslot")
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@NamedQuery(name="Timeslot.findAll", query="SELECT t FROM Timeslot t")
public class Timeslot {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timeslot")
    private int idTimeslot;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "tenniser_id")
    private int tenniserId;

    //bi-directional many-to-one association to TennisCourt
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_court")
    private TennisCourt tennisCourt;

}

