package com.danieleleao.events.modules.events.controllers;

import com.danieleleao.events.modules.events.entities.Event;
import com.danieleleao.events.modules.events.usecases.CreateEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class CreateEventController {

    @Autowired
    private CreateEventUseCase createEventUseCase;

    @PostMapping("/")
    public Event handle(@RequestBody Event event) {
        return this.createEventUseCase.execute(event);
    }
}
