package microservicio.api_rest.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import microservicio.api_rest.models.dtos.NewEstudianteDto;
import microservicio.api_rest.models.entities.Estudiante;
import microservicio.api_rest.repositories.EstudianteRepository;

@Service
public class EstudianteServiceImple implements EstudianteService {

   @Autowired
   private EstudianteRepository repository;

   @Autowired
   private ModelMapper modelMapper;

   @Override
   @Transactional(readOnly = true)
   public List<Estudiante> findAllEstudiantes() {
      List<Estudiante> estudiantes = this.repository.findAll();
      return estudiantes;
   }

   @Override
   @Transactional
   public Estudiante saveEstudiante(NewEstudianteDto newEstudiante) {
      Estudiante estudiante = this.modelMapper.map(newEstudiante, Estudiante.class);
      return this.repository.save(estudiante);
   }

   @Override
   @Transactional(readOnly = true)
   public Estudiante findEstudianteById(Long idEstudiante) {
      Estudiante estudiante = this.repository.findById(idEstudiante).orElse(null);
      return estudiante;
   }

   @Override
   @Transactional
   public Estudiante updateEstudiante(Long idEstudiante, NewEstudianteDto updateEstudiante) {

      Estudiante estudiante = this.repository.findById(idEstudiante).get();

      estudiante.setNombre(updateEstudiante.getNombre());
      estudiante.setEmail(updateEstudiante.getEmail());
      estudiante.setFechaNacimiento(updateEstudiante.getFechaNacimiento());

      return this.repository.save(estudiante);

   }

   @Override
   @Transactional
   public void deleteEstudianteById(long idEstudiante) {
      this.repository.deleteById(idEstudiante);
   }

   @Override
   @Transactional(readOnly = false)
   public Page<Estudiante> findAllEstudiantesWithPagination(Pageable pageable) {
      return this.repository.findAll(pageable);
   }

}