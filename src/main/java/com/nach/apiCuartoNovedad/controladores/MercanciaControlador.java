package com.nach.apiCuartoNovedad.controladores;


import com.nach.apiCuartoNovedad.entidades.Mercancia;
import com.nach.apiCuartoNovedad.servicios.implementaciones.MercanciaServicioImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiTcc/mercancia")
public class MercanciaControlador {

    @Autowired
    MercanciaServicioImplementacion mercanciaServicio;

   @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Mercancia mercancia){
       try{
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(mercanciaServicio.registrar(mercancia));
       }catch (Exception error){
           return  ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("Mensaje: No se pudo Registrar");
       }
   }

   @GetMapping
    public  ResponseEntity<?> buscarTodo(){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(mercanciaServicio.buscarTodos());

       }catch (Exception error){
          return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body("Mensaje: No se Encontro Nada");
       }

   }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(mercanciaServicio.buscarPorId(id));

       } catch (Exception error){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("Mensaje: Mercancia no Encontrada");
       }
   }

   @PutMapping("/{id}")
    public  ResponseEntity<?> actualizar(@PathVariable Integer id,@RequestBody Mercancia mercancia ){

       try {
           return  ResponseEntity
                   .status(HttpStatus.OK)
                   .body(mercanciaServicio.actualizar(id,mercancia));
       }catch (Exception error){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("Mensaje: No se puto Actualizar");
       }
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(mercanciaServicio.borrar(id));
       }catch (Exception error){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("Mensaje: No se pudo Borrar");
       }
   }

}
