package com.example.DlloSoftGrupo4.repositorio;

import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero, Integer> {
}
