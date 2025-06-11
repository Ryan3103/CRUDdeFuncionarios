package com.rh_tech.rh_tech.service;

import com.rh_tech.rh_tech.model.FuncionarioPorCargo;
import com.rh_tech.rh_tech.repository.FuncionarioPorCargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioPorCargoService {
    @Autowired
    private FuncionarioPorCargoRepository repository;

    public FuncionarioPorCargo salvar(FuncionarioPorCargo vinculo) {
        return repository.save(vinculo);
    }

    public List<FuncionarioPorCargo> listar() {
        return repository.findAll();
    }

    public FuncionarioPorCargo buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public FuncionarioPorCargo atualizar(Long id, FuncionarioPorCargo novo) {
        FuncionarioPorCargo existente = repository.findById(id).orElseThrow();
        existente.setFuncionario(novo.getFuncionario());
        existente.setCargo(novo.getCargo());
        existente.setDataInicio(novo.getDataInicio());
        existente.setDataFim(novo.getDataFim());
        existente.setDetalhes(novo.getDetalhes());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<FuncionarioPorCargo> filtrarPorCargo(Long cargoId) {
        return repository.findByCargoId(cargoId);
    }

    public List<FuncionarioPorCargo> filtrarPorFuncionario(Long funcionarioId) {
        return repository.findByFuncionarioId(funcionarioId);
    }
}
