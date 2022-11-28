/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.mundial.repository;


import com.teacher.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectcionRepository  extends JpaRepository<User, Integer> {
    
}
