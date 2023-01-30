package qodous.erp.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qodous.erp.inventory.domain.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {

}
