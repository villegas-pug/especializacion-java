
package microservicio.app_terminal.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.log4j.Log4j2;
import microservicio.app_terminal.Models.Departamento;

@Repository
@Log4j2
public class DepartamentoRepository {

   @Autowired
   private JdbcTemplate jdbcTemplate;

   public void saveDepartamento(Departamento departamento) {

      String sql = "{CALL usp_insertarDepartamento(?, ?)}";

      try (Connection conn = this.jdbcTemplate.getDataSource().getConnection()) {

         CallableStatement ps = conn.prepareCall(sql);
         ps.setString(1, departamento.getNombre());
         ps.setBoolean(2, departamento.isActivo());

         ps.execute();

         log.info(String.format("Departamento: %s, registrado exitosamente!", departamento.getNombre()));

      } catch (SQLException e) {
         String errMesage = String.format("Error al insertar el departamento: %s, error: %s.", departamento.getNombre(),
               e.getMessage());
         log.error(errMesage);
      }

   }

   public Optional<Departamento> findDepartamentoById(Long idDepartamento) {

      String sql = "SELECT * FROM Departamento WHERE id = ?";
      Departamento departamento = null;

      try (Connection conn = this.jdbcTemplate.getDataSource().getConnection()) {

         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, idDepartamento);

         try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
               Departamento
                     .builder()
                     .id(rs.getLong("id"))
                     .nombre(rs.getString("nombre"))
                     .activo(rs.getBoolean("activo"))
                     .build();
            }
         }

         log.info(String.format("Departamento: %s, listado exitosamente!", departamento.getNombre()));

         return Optional.of(departamento);

      } catch (SQLException e) {
         log.error(e.getMessage());
         return null;
      }

   }

   public List<Departamento> findAllDepartamento() {

      String sql = "SELECT * FROM Departamento";

      List<Departamento> departamentos = new ArrayList<>();

      try {

         jdbcTemplate.query(sql, (ResultSet rs) -> {

            departamentos.add(
                  Departamento
                        .builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .activo(rs.getBoolean("activo"))
                        .build()

            );

         });

         return departamentos;

      } catch (Exception e) {
         log.error(e.getMessage());
         return null;
      }

   }

}
