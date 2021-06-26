package com.example.tenniserservice.tenniser;

import lombok.*;

import javax.persistence.*;

@Entity
//@NamedQuery(name="Tenniser.findAll", query="SELECT t FROM Tenniser t")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tenniser {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_tenniser")
    private int idTenniser;

    @Column(name="`e-mail`")
    private String email;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="is_paid")
    private boolean isPaid;

    @Column(name="method_of_payment")
    private String methodOfPayment; //dodati u bazi



}
