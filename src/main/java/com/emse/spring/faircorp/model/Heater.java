package com.emse.spring.faircorp.model;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
public class Heater {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Nullable
    private Long power;

    @NotNull
    @ManyToOne
    private Room room;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HeaterStatus heater_status;

    public Long getHeater_id() {
        return id;
    }

    public void setHeater_id(Long id) {
        this.id = id;
    }

    public String getHeater_name() {
        return name;
    }

    public void setHeater_name(String name) {
        this.name = name;
    }

    public HeaterStatus getHeater_status() {
        return heater_status;
    }

    public void setHeater_status(HeaterStatus heater_status) {
        this.heater_status = heater_status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    Heater(){
    }

    public Heater(Long id, HeaterStatus heater_status, String name, Room room){
        this.heater_status = heater_status;
        this.name = name;
        this.room = room;
        this.id = id;
    }

}
