package com.nach.apiCuartoNovedad.repocitorios;

import com.nach.apiCuartoNovedad.entidades.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository <Zona,Integer> {
}
