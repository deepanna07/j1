package com.sidgs;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int spec_id;
    private String spec_type;
    private String spec_status;
    @OneToOne(cascade = CascadeType.ALL)
    private Animals animals;

    public int getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(int spec_id) {
        this.spec_id = spec_id;
    }

    public String getSpec_type() {
        return spec_type;
    }

    public void setSpec_type(String spec_type) {
        this.spec_type = spec_type;
    }

    public String getSpec_status() {
        return spec_status;
    }

    public void setSpec_status(String spec_status) {
        this.spec_status = spec_status;
    }



    public Animals getAnimals() {
        return animals;
    }

    public void setAnimals(Animals animals) {
        this.animals = animals;
    }
    //    (Cascade =CascadeType.ALL)
//    @JoinColumn(name = "Species1")




}
