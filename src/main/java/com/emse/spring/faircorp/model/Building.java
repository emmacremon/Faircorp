package com.emse.spring.faircorp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "building")
    private Set<Room> room;

    Double outside_temp;

    // Constructeurs
    public Double getOutside_temp() { return outside_temp; }
    public void setOutside_temp(Double outside_temp) { this.outside_temp = outside_temp; }

    public Long getBuildingId() {
        return id;
    }

    // Getters & Setters
    Building(Double outside_temp, Room room){
        this.room = (Set<Room>) room;
        this.outside_temp = outside_temp;
    }
}
