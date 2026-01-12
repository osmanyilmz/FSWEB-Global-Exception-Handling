package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    public KoalaController() {
        this.koalas = new HashMap<>();
    }

    @GetMapping
    public Collection<Koala> findAll() {
        return koalas.values();
    }

    @GetMapping("/{id}")
    public Koala findById(@PathVariable int id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found: " + id, HttpStatus.NOT_FOUND);
        }
        return koalas.get(id);
    }

    @PostMapping
    public Koala save(@RequestBody Koala koala) {
        if (koala.getId() == null) {
            throw new ZooException("Koala id cannot be null", HttpStatus.BAD_REQUEST);
        }
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found: " + id, HttpStatus.NOT_FOUND);
        }
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable int id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found: " + id, HttpStatus.NOT_FOUND);
        }
        return koalas.remove(id);
    }
}
