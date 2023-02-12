package com.nach.apiCuartoNovedad.repocitorios;

import com.nach.apiCuartoNovedad.entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MercanciaRepocitorio extends JpaRepository <Mercancia,Integer> {
}
