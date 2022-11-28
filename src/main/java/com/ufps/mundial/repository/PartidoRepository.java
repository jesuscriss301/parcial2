package com.ufps.mundial.repository;


import com.ufps.mundial.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository    extends JpaRepository<Partido, Integer>  {
    
}
