package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;

@Repository
public interface OrderRepository extends JpaRepository<OrderConsumer, Long> {
}