package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model;

import jakarta.persistence.*;
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
    @JoinColumn(name = "product_id")
    private Product product;
}
