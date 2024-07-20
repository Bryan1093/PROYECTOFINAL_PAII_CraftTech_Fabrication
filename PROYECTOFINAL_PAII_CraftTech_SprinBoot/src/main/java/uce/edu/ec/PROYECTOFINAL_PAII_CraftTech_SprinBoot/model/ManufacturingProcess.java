package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ManufacturingProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String processName;
    private Date startDate;
    private Date endDate;
    private String status;

    @ManyToOne
    private Product product;
}
