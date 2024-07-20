package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IManufacturingProcessDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IManufacturingProcessService;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.ManufacturingProcess;

import java.util.List;

@Service
public class ManufacturingProcessService implements IManufacturingProcessService {

    @Autowired
    private IManufacturingProcessDao manufacturingProcessDao;

    @Override
    public ManufacturingProcess findById(Long id) {
        return manufacturingProcessDao.findById(id);
    }

    @Override
    public ManufacturingProcess save(ManufacturingProcess manufacturingProcess) {
        return manufacturingProcessDao.save(manufacturingProcess);
    }

    @Override
    public void deleteById(Long id) {
        manufacturingProcessDao.deleteById(id);
    }

    @Override
    public List<ManufacturingProcess> findAll() {
        return manufacturingProcessDao.findAll();
    }
}
