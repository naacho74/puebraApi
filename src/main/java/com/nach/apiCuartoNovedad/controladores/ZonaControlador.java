package com.nach.apiCuartoNovedad.controladores;

import com.nach.apiCuartoNovedad.entidades.Zona;
import com.nach.apiCuartoNovedad.servicios.implementaciones.ZonaServicioImplementacion;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiTcc/zonas")
public class ZonaControlador {

    @Autowired
    ZonaServicioImplementacion zonaServicio;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Zona zona){
     try{
         return  ResponseEntity
                 .status(HttpStatus.OK)
                 .body(zonaServicio.registrar(zona));
     }catch (Exception error){
         return  ResponseEntity
                 .status(HttpStatus.BAD_REQUEST)
                 .body("mensaje: Revise su Peticion");
     }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.buscarTodos());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Mensaje: Datos no Encontrados");
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.buscarPorId(id));
        } catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Mensaje: Zona no encontrada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id,@RequestBody Zona tabla ){

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.actualizar(id,tabla));
        } catch (Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Mensaje: No se encontro Registro para Actualizar");
        }

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> borrar(@PathVariable Integer id){

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(zonaServicio.borrar(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Mensaje: No se pudo Borrar ");
        }
    }

}
