package dev.danvega.contentcalendar.controller;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GrapgqlController {

//    @Autowired
//    ContentRepository repository;
    private final ContentRepository repository;

    public GrapgqlController(ContentRepository repository) {
        this.repository = repository;
    }


    @QueryMapping
    public List<Content> findAll() {
        return repository.findAll();
    }
}
