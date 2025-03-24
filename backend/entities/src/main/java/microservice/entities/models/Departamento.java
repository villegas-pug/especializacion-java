package microservice.entities.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = { "id" })
public class Departamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JsonIgnoreProperties(value = { "departamento" })
   private List<Provincia> provincias;

   @Column(nullable = false)
   private String nombre;
   
   @Column(nullable = false)
   private @Builder.Default boolean activo = true;
   
}