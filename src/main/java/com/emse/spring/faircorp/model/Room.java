package com.emse.spring.faircorp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private int floor;
    private Double current_temperature;
    private Double target_temperature;
    @NotNull
    private String name;

    private Long heater_id;
    private String heater_name;
    private HeaterStatus heater_status;
    @OneToMany(mappedBy = "room")
    private Set<Heater> heater;

    private Long window_id;
    private String window_name;
    private WindowStatus window_status;
    @OneToMany(mappedBy = "room")
    private Set<Window> window;

    @ManyToOne
    private Building building;

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) { this.floor = floor; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getCurrent_temperature() { return current_temperature; }
    public void setCurrent_temperature(Double current_temperature) { this.current_temperature = current_temperature; }
    public Double getTarget_temperature() { return target_temperature; }
    public void setTarget_temperature(Double target_temperature) { this.target_temperature = target_temperature; }

    public Long getHeater_id() {
        return heater_id;
    }
    public void setHeater_id(Long heater_id) {
        this.heater_id = heater_id;
    }
    public String getHeater_name() {
        return heater_name;
    }
    public void setHeater_name(String heater_name) {
        this.heater_name = heater_name;
    }
    public HeaterStatus getHeater_status() {
        return heater_status;
    }
    public void setHeater_status(HeaterStatus heater_status) {
        this.heater_status = heater_status;
    }
    public Set<Heater> getHeaters() {
        return heater;
    }
    public void setHeaters(Set<Heater> heater) {
        this.heater = heater;
    }

    public Long getWindow_id() {
        return window_id;
    }
    public void setWindow_id(Long window_id) {
        this.window_id = window_id;
    }
    public String getWindow_name() {
        return window_name;
    }
    public void setWindow_name(String window_name) {
        this.window_name = window_name;
    }
    public WindowStatus getWindow_status() {
        return window_status;
    }
    public void setWindow_status(WindowStatus window_status) {
        this.window_status = window_status;
    }
    public Set<Window> getWindows() {
        return window;
    }
    public void setWindows(Set<Window> window) {
        this.window = window;
    }

    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    // Constructeurs
    public Room(String name, Long id, int floor, Long heater_id, String heater_name, HeaterStatus heater_status, Long window_id, String window_name, WindowStatus window_status, Double current_temperature, Double target_temperature) {
        this.name = name;
        this.id = id;
        this.floor = floor;
        this.heater_id = heater_id;
        this.heater_name  = heater_name;
        this.heater_status = heater_status;
        this.window_id = window_id;
        this.window_name  = window_name;
        this.window_status = window_status;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
    }

    public Room(){}

}