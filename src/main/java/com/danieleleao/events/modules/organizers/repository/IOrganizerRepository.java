package com.danieleleao.events.modules.organizers.repository;

import com.danieleleao.events.modules.organizers.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IOrganizerRepository extends JpaRepository<Organizer, UUID> {
    Organizer findByEmail(String email);
}
