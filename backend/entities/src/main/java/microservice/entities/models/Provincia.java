package microservice.entities.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Provincia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = { "id" })
public class Provincia {

   @Id
   private Long id;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "idDepartamento", nullable = false)
   private Departamento departamento;

   @OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JsonIgnoreProperties(value = { "provincia" })
   private List<Distrito> distritos;

   @Column(nullable = false)
   private String nombre;
   
   @Column(nullable = false)
   private @Builder.Default boolean activo = true;
   
}
