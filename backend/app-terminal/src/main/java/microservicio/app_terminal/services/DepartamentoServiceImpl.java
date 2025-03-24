package microservicio.app_terminal.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import microservicio.app_terminal.Models.Departamento;
import microservicio.app_terminal.repositories.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

   @Autowired
   private DepartamentoRepository repository;

   @Override
   @Transactional
   public void saveDepartamento(Departamento departamento) {
      this.repository.saveDepartamento(departamento);
   }

   @Override
   @Transactional(readOnly = true)
   public Departamento findDepartamentoById(Long idDepartamento) {
      return this.repository.findDepartamentoById(idDepartamento).orElse(null);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Departamento> findAllDepartamento() {
      return this.repository.findAllDepartamento();
   }
   
}
