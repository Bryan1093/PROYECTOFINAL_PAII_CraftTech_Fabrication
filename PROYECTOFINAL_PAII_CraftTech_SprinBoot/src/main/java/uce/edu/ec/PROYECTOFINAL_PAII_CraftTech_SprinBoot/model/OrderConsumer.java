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
public class OrderConsumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String producto;
    private int fabricationTimeInSeconds;
    private String cliente;
    private Date fecha;

    @OneToOne(mappedBy = "orderConsumer")
    private ManufacturingProcess manufacturingProcess;
}
