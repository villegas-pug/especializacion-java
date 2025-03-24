package microservice.entities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Distrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = { "id" })
public class Distrito {

   @Id
   private Long id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "idProvincia", nullable = false)
   private Provincia provincia;
   
   @Column(nullable = false)
   private String nombre;
   
   @Column(nullable = false)
   private @Builder.Default boolean activo = true;
   
}

