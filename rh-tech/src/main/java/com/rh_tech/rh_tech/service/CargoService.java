package com.rh_tech.rh_tech.service;

import com.rh_tech.rh_tech.model.Cargo;
import com.rh_tech.rh_tech.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository repository;

    public List<Cargo> listar() {
        return repository.findAll();
    }

    public Cargo salvar(Cargo cargo) {
        return repository.save(cargo);
    }

    public Cargo atualizar(Long id, Cargo novoCargo) {
        Cargo existente = repository.findById(id).orElseThrow();
        existente.setNome(novoCargo.getNome());
        existente.setDescricao(novoCargo.getDescricao());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
