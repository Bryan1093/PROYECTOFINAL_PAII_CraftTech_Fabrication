package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.ManufacturingProcess;

import java.util.List;

public interface IManufacturingProcessService {
    ManufacturingProcess findById(Long id);
    ManufacturingProcess save(ManufacturingProcess manufacturingProcess);
    void deleteById(Long id);
    List<ManufacturingProcess> findAll();
}
