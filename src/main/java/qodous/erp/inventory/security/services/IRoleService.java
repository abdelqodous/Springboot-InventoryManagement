package qodous.erp.inventory.security.services;

import qodous.erp.inventory.security.domain.Role;

import java.util.Optional;

public interface IRoleService {
    public Optional<Role> findById(Long roleId);
}
