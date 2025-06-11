package com.rh_tech.rh_tech.controller;

import com.rh_tech.rh_tech.model.FuncionarioPorCargo;
import com.rh_tech.rh_tech.service.FuncionarioPorCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios-por-cargo")
@CrossOrigin
public class FuncionarioPorCargoController {
    @Autowired
    private FuncionarioPorCargoService service;

    @PostMapping
    public FuncionarioPorCargo criar(@RequestBody FuncionarioPorCargo vinculo) {
        return service.salvar(vinculo);
    }

    @GetMapping
    public List<FuncionarioPorCargo> listar(@RequestParam(required = false) Long cargoId,
                                            @RequestParam(required = false) Long funcionarioId) {
        if (cargoId != null) return service.filtrarPorCargo(cargoId);
        if (funcionarioId != null) return service.filtrarPorFuncionario(funcionarioId);
        return service.listar();
    }

    @GetMapping("/{id}")
    public FuncionarioPorCargo buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FuncionarioPorCargo atualizar(@PathVariable Long id, @RequestBody FuncionarioPorCargo vinculo) {
        return service.atualizar(id, vinculo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
