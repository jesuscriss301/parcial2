package com.ufps.mundial.repository;
import com.ufps.mundial.model.Continente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinenteRepository   extends JpaRepository<Continente, Integer>  {
    
}
