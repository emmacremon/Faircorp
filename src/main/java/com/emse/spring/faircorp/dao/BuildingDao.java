package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDao {
    @Query("select b from Building b where b.id=:id")
    public Building getRoom(@Param("id") Long id);

    @Query("select * from Room in :id_list")
    List<Window> findAll(@Param("id_list") List<Long> id_list);

    @Query("select w from Window w where w.room=:room")
    public Room getWindows(@Param("room") Long room);
}
