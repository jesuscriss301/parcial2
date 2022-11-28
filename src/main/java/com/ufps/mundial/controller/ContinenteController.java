package com.ufps.mundial.controller;


import com.ufps.mundial.model.Continente;
import com.ufps.mundial.repository.ContinenteRepository;

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


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Continentes")
public class ContinenteController {
    @Autowired
    ContinenteRepository continenteRepo;

    @GetMapping
    public List<Continente> getContinenteAll() {
        return continenteRepo.findAll();
    }

    @GetMapping("/{id}")
    public Continente getContinentesbyId(@PathVariable Integer id) {
        Optional<Continente> continente = continenteRepo.findById(id);

        if (continente.isPresent()) {
            return continente.get();
        }

        return null;
    }

    @PostMapping
    public Continente postContinentes(@RequestBody Continente continente) {
        continenteRepo.save(continente);
        return continente;
    }


    @PutMapping("/{id}")
    public Continente putContinentesbyId(@PathVariable Integer id, @RequestBody Continente continente) {
        Optional<Continente> continenteCurrent = continenteRepo.findById(id);

        if (continenteCurrent.isPresent()) {
            Continente continenteReturn = continenteCurrent.get();
            continenteReturn.setNombre(continente.getNombre());

            continenteRepo.save(continenteReturn);
            return continenteReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Continente deleteContinentesbyId(@PathVariable Integer id) {
        Optional<Continente> continente = continenteRepo.findById(id);

        if (continente.isPresent()) {
            Continente continenteReturn = continente.get();
            continenteRepo.deleteById(id);
            return continenteReturn;
        }

        return null;
    }
}
