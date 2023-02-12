package com.nach.apiCuartoNovedad.servicios.implementaciones;

import com.nach.apiCuartoNovedad.entidades.Zona;
import com.nach.apiCuartoNovedad.repocitorios.ZonaRepositorio;
import com.nach.apiCuartoNovedad.servicios.ServicioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicioImplementacion implements ServicioGenerico<Zona> {


    @Autowired
    ZonaRepositorio zonaRepositorio;


    @Override
    public List<Zona> buscarTodos() throws Exception {
        try {
            List<Zona>zonas=zonaRepositorio.findAll();
            return zonas;
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona buscarPorId(Integer id) throws Exception {
        try {
            Optional<Zona>zona=zonaRepositorio.findById(id);
            return zona.get();
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona registrar(Zona tabla) throws Exception {
        try {
        tabla=zonaRepositorio.save(tabla);
            return tabla;
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Zona actualizar(Integer id, Zona tabla) throws Exception {
        try {
            Optional<Zona> zonaBuscada=zonaRepositorio.findById(id);
            Zona zona=zonaBuscada.get();
            zona=zonaRepositorio.save(tabla);
            return zona;

    }catch (Exception error) {
        throw new Exception(error.getMessage());
    }
    }

    @Override
    public Boolean borrar(Integer id) throws Exception {
        try {
            if (zonaRepositorio.existsById(id)){
                zonaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
