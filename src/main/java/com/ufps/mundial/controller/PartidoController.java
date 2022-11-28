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

import com.ufps.mundial.model.Partido;
import com.ufps.mundial.repository.PartidoRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Partidos")
public class PartidoController {
    @Autowired
    PartidoRepository partidoRepo;

    @GetMapping
    public List<Partido> getPartidoAll() {
        return partidoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Partido getPartidosbyId(@PathVariable Integer id) {
        Optional<Partido> partido = partidoRepo.findById(id);

        if (partido.isPresent()) {
            return partido.get();
        }

        return null;
    }

    @PostMapping
    public Partido postPartidos(@RequestBody Partido partido) {
        partidoRepo.save(partido);
        return partido;
    }


    @PutMapping("/{id}")
    public Partido putPartidosbyId(@PathVariable Integer id, @RequestBody Partido partido) {
        Optional<Partido> partidoCurrent = partidoRepo.findById(id);

        if (partidoCurrent.isPresent()) {
            Partido partidoReturn = partidoCurrent.get();
            partidoReturn.setFecha(partido.getFecha());
            partidoReturn.setEstadio_id(partido.getEstadio_id());

            partidoRepo.save(partidoReturn);
            return partidoReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Partido deletePartidosbyId(@PathVariable Integer id) {
        Optional<Partido> partido = partidoRepo.findById(id);

        if (partido.isPresent()) {
            Partido partidoReturn = partido.get();
            partidoRepo.deleteById(id);
            return partidoReturn;
        }

        return null;
    }
}