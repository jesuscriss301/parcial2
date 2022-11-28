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

import com.ufps.mundial.model.Resultado;
import com.ufps.mundial.repository.ResultadoRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Resultados")
public class ResultadoController {
    @Autowired
    ResultadoRepository resultadoRepo;

    @GetMapping
    public List<Resultado> getResultadoAll() {
        return resultadoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Resultado getResultadosbyId(@PathVariable Integer id) {
        Optional<Resultado> resultado = resultadoRepo.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        }

        return null;
    }

    @PostMapping
    public Resultado postResultados(@RequestBody Resultado resultado) {
        resultadoRepo.save(resultado);
        return resultado;
    }


    @PutMapping("/{id}")
    public Resultado putResultadosbyId(@PathVariable Integer id, @RequestBody Resultado resultado) {
        Optional<Resultado> resultadoCurrent = resultadoRepo.findById(id);

        if (resultadoCurrent.isPresent()) {
            Resultado resultadoReturn = resultadoCurrent.get();
            resultadoReturn.setPartido_id(resultado.getPartido_id());
            resultadoReturn.setSeleccion_id(resultado.getSeleccion_id());
            resultadoReturn.setGoles(resultado.getGoles());
            resultadoReturn.setAmarillas(resultado.getAmarillas());
            resultadoReturn.setRojas(resultado.getRojas());

            resultadoRepo.save(resultadoReturn);
            return resultadoReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Resultado deleteResultadosbyId(@PathVariable Integer id) {
        Optional<Resultado> resultado = resultadoRepo.findById(id);

        if (resultado.isPresent()) {
            Resultado resultadoReturn = resultado.get();
            resultadoRepo.deleteById(id);
            return resultadoReturn;
        }

        return null;
    }
}