package qodous.erp.inventory.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qodous.erp.inventory.security.repositories.IRoleRepository;
import qodous.erp.inventory.security.domain.Role;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    IRoleRepository roleRepository;

    public Optional<Role> findById(Integer roleId){
        return roleRepository.findById(roleId);
    }
}
