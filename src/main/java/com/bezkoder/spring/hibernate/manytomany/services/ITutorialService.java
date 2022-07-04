/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bezkoder.spring.hibernate.manytomany.services;

import com.bezkoder.spring.hibernate.manytomany.model.Tutorial;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author mac
 */
public interface ITutorialService {
    
    ResponseEntity<List<Tutorial>> getAllTutorials(String title);
    
}
