package dev.danvega.contentcalendar.controller;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @QueryMapping
    public Content findById(@Argument Integer id) {
        return (repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.")));
    }

    @MutationMapping
    public Content create(@Argument Content content) {
        return repository.save(content);
    }
}
