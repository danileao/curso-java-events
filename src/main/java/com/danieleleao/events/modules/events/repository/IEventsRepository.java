package com.danieleleao.events.modules.events.repository;

import com.danieleleao.events.modules.events.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEventsRepository extends JpaRepository<Event, UUID> {
}
