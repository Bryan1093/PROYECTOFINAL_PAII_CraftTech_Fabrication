package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IManufacturingProcessDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.repository.ManufacturingProcessRepository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.ManufacturingProcess;

import java.util.List;
@Repository
public class ManufacturingProcessImpl implements IManufacturingProcessDao {

    @Autowired
    private ManufacturingProcessRepository manufacturingProcessRepository;

    @Override
    public ManufacturingProcess findById(Long id) {
        return manufacturingProcessRepository.findById(id).orElse(null);
    }

    @Override
    public ManufacturingProcess save(ManufacturingProcess manufacturingProcess) {
        return manufacturingProcessRepository.save(manufacturingProcess);
    }

    @Override
    public void deleteById(Long id) {
        manufacturingProcessRepository.deleteById(id);
    }

    @Override
    public List<ManufacturingProcess> findAll() {
        return manufacturingProcessRepository.findAll();
    }
}
