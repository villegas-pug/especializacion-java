package microservicio.api_rest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import microservicio.api_rest.models.dtos.NewEstudianteDto;
import microservicio.api_rest.models.entities.Estudiante;

public interface EstudianteService {

   List<Estudiante> findAllEstudiantes();

   Page<Estudiante> findAllEstudiantesWithPagination(Pageable pageable);

   Estudiante saveEstudiante(NewEstudianteDto estudiante);

   Estudiante updateEstudiante(Long idEstudiante, NewEstudianteDto estudiante);

   Estudiante findEstudianteById(Long idEstudiante);

   void deleteEstudianteById(long idEstudiante);

}