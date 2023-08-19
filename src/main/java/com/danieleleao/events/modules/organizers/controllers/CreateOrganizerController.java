package com.danieleleao.events.modules.organizers.controllers;

import com.danieleleao.events.modules.organizers.entities.Organizer;
import com.danieleleao.events.modules.organizers.usecases.CreateOrganizerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizers")
public class CreateOrganizerController {

    @Autowired
    private CreateOrganizerUseCase createOrganizerUseCase;

    @PostMapping("/")
    public Organizer handle(@RequestBody Organizer organizer) {
           return  this.createOrganizerUseCase.execute(organizer);
    }
}
