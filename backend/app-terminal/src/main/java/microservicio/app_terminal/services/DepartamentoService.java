package microservicio.app_terminal.services;

import java.util.List;
import microservicio.app_terminal.Models.Departamento;

public interface DepartamentoService {
   
   public void saveDepartamento(Departamento departamento);
   public Departamento findDepartamentoById(Long idDepartamento);
   public List<Departamento> findAllDepartamento();

}
