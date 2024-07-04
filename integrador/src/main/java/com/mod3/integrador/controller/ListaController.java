package com.mod3.integrador.controller;

import com.mod3.integrador.model.Carro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lista")
public class ListaController {

    private List carros = new ArrayList<>();
    private int proximoId = 1;

    @PostMapping("")
    public Carro criarCarro(@RequestBody Carro c) {
        c.setId(proximoId++);
        carros.add(c);
        return c;
    }

    @GetMapping("")
    public List buscarCarros() {
        return carros;
    }
    @PutMapping("/{id}")
    
    public Carro atualizarTarefa(@PathVariable int id, @RequestBody Carro c) {
        for (int i = 0; i < carros.size(); i++) {
            Carro t = (Carro) carros.get(i);
            if (t.getId() == id) {
                t.setModelo(c.getModelo());
                t.setMarca(c.getMarca());
                t.setAno(c.getAno());
                t.setDisponivel(c.getDisponivel());
                return t;
            } 

        } 

        return null;
    

    } 
}
