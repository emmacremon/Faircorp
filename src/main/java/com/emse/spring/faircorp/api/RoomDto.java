package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.*;

import java.util.Set;

public class RoomDto {

    private String roomName;
    private Long roomId;
    private int floor;
    private Double current_temperature;
    private Double target_temperature;

    private Set<Heater> heater;
    private Long heater_id;
    private String heater_name;
    private HeaterStatus heaterStatus;

    private Set<Window> window;
    private Long window_id;
    private String window_name;
    private WindowStatus windowStatus;


    // Getters & Setters
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
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }
    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
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
    public WindowStatus getWindowStatus() {
        return windowStatus;
    }
    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Long getRoomId() {
        return roomId;
    }
    public void setRoomId(Long id) {
        this.roomId = roomId;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) { this.roomName = roomName; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
    public Double getCurrent_temperature() { return current_temperature; }
    public void setCurrent_temperature(Double current_temperature) { this.current_temperature = current_temperature; }
    public Double getTarget_temperature() { return target_temperature; }
    public void setTarget_temperature(Double target_temperature) { this.target_temperature = target_temperature; }


    // Constructeurs
    public RoomDto() {
    }

    public RoomDto(Room room){
        super();
        this.roomName = room.getName();
        this.roomId = room.getId();
        this.floor = room.getFloor();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.heater = room.getHeaters();
        this.window = room.getWindows();
    }

}

