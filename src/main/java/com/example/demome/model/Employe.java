package com.example.demome.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employe {

    @Id
    @SequenceGenerator(
            name = "employe_sequence",
            sequenceName = "employe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employe_sequence"
    )
    private Long id;
    private String nom;
    private String email;
    private LocalDate date_naiss;
    @Transient
    private Integer age;

    public Employe() {
    }

    public Employe(String nom, String email, LocalDate date_naiss, Integer age) {
        this.nom = nom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate_naiss() {
        return this.date_naiss;
    }

    public void setDate_naiss(LocalDate date_naiss) {
        this.date_naiss = date_naiss;
    }

    public Integer getAge() {
        return Period.between(this.date_naiss, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
