package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long> {
    @Query("select c from Room c where c.name=:name")
    Room findByName(@Param("name") String name);

    @Query("select r from Room r where r.id=:id")
    public Room getOne(@Param("id") Long id);

    @Query("select w from Window w where w.room=:room")
    public Room getWindows(@Param("room") Long room);
}
