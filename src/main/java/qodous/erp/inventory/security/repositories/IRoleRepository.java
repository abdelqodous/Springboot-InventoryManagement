package qodous.erp.inventory.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qodous.erp.inventory.security.domain.Role;

@Repository
public interface IRoleRepository  extends JpaRepository<Role, Integer> {
}
