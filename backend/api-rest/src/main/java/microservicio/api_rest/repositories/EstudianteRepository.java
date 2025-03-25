package microservicio.api_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import microservicio.api_rest.models.entities.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}