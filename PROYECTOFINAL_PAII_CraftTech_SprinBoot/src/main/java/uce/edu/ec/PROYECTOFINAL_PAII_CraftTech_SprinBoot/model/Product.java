package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String category;

    @OneToMany(mappedBy = "product")
    private List<ManufacturingProcess> manufacturingProcesses;
}
