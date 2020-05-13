package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private long id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "doctor_surname")
    private String surname;

    @Column(name = "doctor_spec")
    private String spec;

    @Column(name = "doctor_region")
    private String region;
}
