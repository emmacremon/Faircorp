package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;
    private final WindowDao windowDao;

    public RoomController(RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao) {
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
    }

    @GetMapping //Liste de toutes les salles
    public List<RoomDto> findAll() { return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList()); }

    @GetMapping(path = "/{room_id}") //Trouve une salle avec son id
    public RoomDto findById(@PathVariable Long room_id) {
        return roomDao.findById(room_id).map(RoomDto::new).orElse(null);
    }

    @PostMapping //ajoute une salle
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        // On creation id is not defined
        if (dto.getRoomId() == null) {
            room = roomDao.save(new Room(dto.getRoomName(), dto.getRoomId(), dto.getFloor(), dto.getHeater_id(), dto.getHeater_name(), dto.getHeaterStatus(), dto.getWindow_id(), dto.getWindow_name(), dto.getWindowStatus(), dto.getCurrent_temperature(), dto.getTarget_temperature()));
        } else {
            room = roomDao.getById(dto.getRoomId());
            room.setName(dto.getRoomName());
            room.setFloor(dto.getFloor());
            room.getCurrent_temperature();
            room.getTarget_temperature();

            room.setHeater_id(dto.getHeater_id());
            room.setHeater_name(dto.getHeater_name());
            room.setHeater_status(dto.getHeaterStatus());

            room.setWindow_id(dto.getWindow_id());
            room.setWindow_name(dto.getWindow_name());
            room.setWindow_status(dto.getWindowStatus());
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{room_id}") // Supprime une salle, ses fenêtres et ses radiateurs
    public void delete(@PathVariable Long room_id) {
        windowDao.deleteByRoom(room_id);
        heaterDao.deleteByRoom(room_id);
        roomDao.deleteById(room_id);
    }

    @PutMapping(path = "/{room_id}/switchWindows")
    public RoomDto switchWindows(@PathVariable Long room_id) {
        Room room = roomDao.findById(room_id).orElseThrow(IllegalArgumentException::new);
        room.getWindows().forEach(window->
                window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN)
        );
        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public RoomDto switchHeaters(@PathVariable Long roomId) {
        Room room = roomDao.findById(roomId).orElseThrow(IllegalArgumentException::new);
        room.getHeaters().forEach(heater->
                heater.setHeater_status(heater.getHeater_status() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON)
        );
        return new RoomDto(room);
    }

}

