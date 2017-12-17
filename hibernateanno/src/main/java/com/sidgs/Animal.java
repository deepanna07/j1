package com.sidgs;



import javax.persistence.*;

import java.util.Date;
@Entity
public class Animal {
    @Id
    private int animal_id;
    private String animal_Name;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getAnimal_Name() {
        return animal_Name;
    }

    public void setAnimal_Name(String animal_Name) {
        this.animal_Name = animal_Name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
