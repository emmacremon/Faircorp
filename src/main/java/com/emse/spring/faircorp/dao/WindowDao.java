package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long> , WindowDaoCustom {

    @Query("select w from Window w where w.name=:name")
    Window findByName(@Param("name") String name);

    @Query("select w from Window w inner join w.room r where r.id in :id_list")
    List<Window> findAllById(@Param("id_list") List<Long> id_list);

    @Query("select w from Window w where w.id=:id")
    public Window getById(@Param("id") Long id );

    @Modifying
    @Query("delete from Window w where w.room.id=:id")
    void deleteByRoom(@Param("id") Long id);

}
