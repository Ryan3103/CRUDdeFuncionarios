package com.rh_tech.rh_tech.repository;

import com.rh_tech.rh_tech.model.FuncionarioPorCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioPorCargoRepository extends JpaRepository<FuncionarioPorCargo, Long> {
    List<FuncionarioPorCargo> findByCargoId(Long cargoId);
    List<FuncionarioPorCargo> findByFuncionarioId(Long funcionarioId);
}
