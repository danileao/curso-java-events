package com.danieleleao.events.modules.organizers.usecases;

import com.danieleleao.events.modules.organizers.entities.Organizer;
import com.danieleleao.events.modules.organizers.repository.IOrganizerRepository;
import com.danieleleao.events.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateOrganizerUseCase {

    @Autowired
    private IOrganizerRepository organizerRepository;

    public Organizer execute(Organizer organizer) {
        var existOrganizer = this.organizerRepository.findByEmail(organizer.getEmail());
        if(existOrganizer != null) {
            throw new CustomException("Organizer already exists", HttpStatus.CONFLICT);
        }

        return this.organizerRepository.save(organizer);
    }
}
