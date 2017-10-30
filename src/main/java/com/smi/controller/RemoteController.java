/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smi.controller;

import com.smi.model.Statistique;
import com.smi.service.StatistiqueService;
import java.security.Principal;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nejm
 */
@RestController
public class RemoteController {

    @Autowired
    @Qualifier("statService")
    StatistiqueService statistiqueService;

    @RequestMapping(value = "/remote/statistiques/visualize", method = RequestMethod.POST)
    public ResponseEntity<Statistique> visualizeRemoteStat(@RequestBody JSONObject obj) {
        Statistique stat = new Statistique();
        if(obj.get("username").toString().equalsIgnoreCase("nejm")){
            stat = statistiqueService.findById(Long.valueOf(obj.get("id").toString()));
        }
        return new ResponseEntity<Statistique>(stat, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/remote/statistiques", method = RequestMethod.GET)
    public ResponseEntity<List<Statistique>> getAll() {
        List<Statistique> stats = statistiqueService.findAll();
        return new ResponseEntity<List<Statistique>>(stats, HttpStatus.OK);
    }
}
