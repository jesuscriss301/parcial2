package com.ufps.mundial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.mundial.model.Estadio;
import com.ufps.mundial.repository.EstadioRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Estadios")
public class EstadioController {
    @Autowired
EstadioRepository estadioRepo;

@GetMapping
public List<Estadio> getEstadioAll() {
    return estadioRepo.findAll();
}

@GetMapping("/{id}")
public Estadio getEstadiosbyId(@PathVariable Integer id) {
    Optional<Estadio> estadio = estadioRepo.findById(id);

    if (estadio.isPresent()) {
        return estadio.get();
    }

    return null;
}

@PostMapping
public Estadio postEstadios(@RequestBody Estadio estadio) {
    estadioRepo.save(estadio);
    return estadio;
}


@PutMapping("/{id}")
public Estadio putEstadiosbyId(@PathVariable Integer id, @RequestBody Estadio estadio) {
    Optional<Estadio> estadioCurrent = estadioRepo.findById(id);

    if (estadioCurrent.isPresent()) {
        Estadio estadioReturn = estadioCurrent.get();
        estadioReturn.setNombre(estadio.getNombre());

        estadioRepo.save(estadioReturn);
        return estadioReturn;
    }

    return null;
}

@DeleteMapping("/{id}")
public Estadio deleteEstadiosbyId(@PathVariable Integer id) {
    Optional<Estadio> estadio = estadioRepo.findById(id);

    if (estadio.isPresent()) {
        Estadio estadioReturn = estadio.get();
        estadioRepo.deleteById(id);
        return estadioReturn;
    }

    return null;
}
}
