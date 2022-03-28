package com.training.redditclone.repositories;

import com.training.redditclone.entities.Event;
import com.training.redditclone.entities.Office;
import com.training.redditclone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {

    @Query("select e from Event e inner join e.users u where e.idEvent=:idEvent and u.userId=:idUser")
    Event retrieveEventByUserIdAndEventId(@Param("idEvent") Integer idEvent, @Param("idUser") Integer IdUser);


    List<Event> findByUsers(User user);

    List<Event> findByOffices(Office office);

}
