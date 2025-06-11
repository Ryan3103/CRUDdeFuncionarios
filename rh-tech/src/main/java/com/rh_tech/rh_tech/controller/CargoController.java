package com.rh_tech.rh_tech.controller;

import com.rh_tech.rh_tech.model.Cargo;
import com.rh_tech.rh_tech.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@CrossOrigin
public class CargoController {
    @Autowired
    private CargoService service;

    @GetMapping
    public List<Cargo> listar() {
        return service.listar();
    }

    @PostMapping
    public Cargo criar(@RequestBody Cargo cargo) {
        return service.salvar(cargo);
    }

    @PutMapping("/{id}")
    public Cargo atualizar(@PathVariable Long id, @RequestBody Cargo cargo) {
        return service.atualizar(id, cargo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
