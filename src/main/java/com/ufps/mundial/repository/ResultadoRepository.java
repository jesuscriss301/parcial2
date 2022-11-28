package com.ufps.mundial.repository;


import com.ufps.mundial.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository   extends JpaRepository<Resultado, Integer> {
    
}
