package microservicio.api_rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicio.api_rest.models.dtos.NewEstudianteDto;
import microservicio.api_rest.models.entities.Estudiante;
import microservicio.api_rest.services.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = { "*" })
@RestController
public class EstudianteController {

   @Autowired
   private EstudianteService service;

   @GetMapping(path = { "/findAllEstudiantes" })
   @ResponseStatus(code = HttpStatus.OK)
   public ResponseEntity<?> findAllEstudiantes() {
      return ResponseEntity.ok(this.service.findAllEstudiantes());
   }

   @GetMapping(path = { "/findAllEstudiantesWithPagination" })
   public ResponseEntity<Page<Estudiante>> findAllEstudiantesWithPagination(@RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "10") int size) {

      Pageable pageable = PageRequest.of(page, size);
      return ResponseEntity.ok(this.service.findAllEstudiantesWithPagination(pageable));
   }

   @PostMapping(path = { "/saveStudiante" })
   @ResponseStatus(code = HttpStatus.CREATED)
   public ResponseEntity<?> saveStudiante(@RequestBody NewEstudianteDto estudiante) {
      return ResponseEntity.ok(this.service.saveEstudiante(estudiante));
   }

   @GetMapping(path = { "/findEstudianteById/{idEstudiante}" })
   @ResponseStatus(code = HttpStatus.OK)
   public ResponseEntity<?> findEstudianteById(@PathVariable Long idEstudiante) {
      Estudiante estudiante = this.service.findEstudianteById(idEstudiante);
      return ResponseEntity.ok(estudiante);
   }

   @PutMapping(path = { "/updateEstudiante/{idEstudiante}" })
   @ResponseStatus(code = HttpStatus.OK)
   public ResponseEntity<?> updateEstudiante(@PathVariable Long idEstudiante,
         @RequestBody NewEstudianteDto estudiante) {
      return ResponseEntity.ok(this.service.updateEstudiante(idEstudiante, estudiante));
   }

   @DeleteMapping(path = { "/deleteEstudianteById/{idEstudiante}" })
   public ResponseEntity<Void> deleteEstudianteById(@PathVariable Long idEstudiante) {
      this.service.deleteEstudianteById(idEstudiante);
      return ResponseEntity.noContent().build();
   }

}