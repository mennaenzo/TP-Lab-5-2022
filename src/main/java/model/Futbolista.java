package model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("futbolista")
@EqualsAndHashCode(callSuper = true)
public class Futbolista extends Deportista{
    private Integer totalGoles;
    private Integer golesPenal;
    private Integer golescabeza;
    private Integer golesTiroLibre;
}
