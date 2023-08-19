package com.danieleleao.events.modules.events.usecases;

import com.danieleleao.events.modules.events.entities.Event;
import com.danieleleao.events.modules.events.repository.IEventsRepository;
import com.danieleleao.events.modules.organizers.repository.IOrganizerRepository;
import com.danieleleao.events.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateEventUseCase {

    @Autowired
    private IEventsRepository eventsRepository;

    @Autowired
    private IOrganizerRepository organizerRepository;

    public Event execute(Event event) {

        // Validar se organizer existe
        var existsOrganizer = this.organizerRepository.findById(event.getOrganizerId());

        if(existsOrganizer == null) {
            throw  new CustomException("Organizer invalid", HttpStatus.NOT_FOUND);
        }
        if(event.getAvailableQuantity() == 0) {
            event.setAvailableQuantity(event.getQuantity());
        }

        return this.eventsRepository.save(event);
    }
}
