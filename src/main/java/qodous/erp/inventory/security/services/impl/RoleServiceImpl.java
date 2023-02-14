package qodous.erp.inventory.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qodous.erp.inventory.security.repositories.IRoleRepository;
import qodous.erp.inventory.security.domain.Role;
import qodous.erp.inventory.security.services.IRoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    public Optional<Role> findById(int roleId){
        return roleRepository.findById(roleId);
    }
}
