package com.sidgs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animals {
//    public int getAnimalId() {
//        return animalId;
//    }
//
//    public void setAnimalId(int animalId) {
//        this.animalId = animalId;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int animalId;

    @Id
    private String animal_name;

    private String animal_type;
    public String getAnimal_name() {


        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }



}
