package com.nach.apiCuartoNovedad.servicios.implementaciones;

import com.nach.apiCuartoNovedad.entidades.Mercancia;
import com.nach.apiCuartoNovedad.entidades.Zona;
import com.nach.apiCuartoNovedad.repocitorios.MercanciaRepocitorio;
import com.nach.apiCuartoNovedad.repocitorios.ZonaRepositorio;
import com.nach.apiCuartoNovedad.servicios.ServicioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicioImplementacion implements ServicioGenerico<Mercancia> {

    @Autowired
    MercanciaRepocitorio mercanciaRepocitorio;
    @Autowired
    ZonaRepositorio zonaRepositorio;


    @Override
    public List<Mercancia> buscarTodos() throws Exception {
        try {
            List<Mercancia> mercancias = mercanciaRepocitorio.findAll();
            return mercancias;
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    @Override
    public Mercancia buscarPorId(Integer id) throws Exception {
        try {
            Optional<Mercancia> mercancia=mercanciaRepocitorio.findById(id);
            return  mercancia.get();

        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia registrar(Mercancia tabla) throws Exception {
        try{

        Optional<Zona> zonaAsociadaAMercancia =zonaRepositorio.findById(tabla.getZona().getId());
        Double capacidadZona=zonaAsociadaAMercancia.get().getDisponible();
        Double capacidadOcupadaMercancia=tabla.getVolumen();
        Double capacidadZonaActualizado=(capacidadZona-capacidadOcupadaMercancia);

        if(capacidadZonaActualizado>=0){

         zonaAsociadaAMercancia.get().setDisponible(capacidadZonaActualizado);
         zonaRepositorio.save(zonaAsociadaAMercancia.get());
         tabla=mercanciaRepocitorio.save(tabla);
          return tabla;
        }else {
            throw  new Exception("No tenemos capacidad para esta Mercancia");
        }


        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Mercancia actualizar(Integer id, Mercancia tabla) throws Exception {
        try {
            Optional<Mercancia> mercanciaBuscada=mercanciaRepocitorio.findById(id);

          Mercancia mercancia= mercanciaBuscada.get();
          mercancia= mercanciaRepocitorio.save(tabla);
          return mercancia;

        }catch (Exception error){

            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Boolean borrar(Integer id) throws Exception {
        try{
            if(mercanciaRepocitorio.existsById(id)){
                mercanciaRepocitorio.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
