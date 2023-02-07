package qodous.erp.security.services;

import qodous.erp.security.domain.Role;

import java.util.Optional;

public interface IRoleService {
    public Optional<Role> findById(int roleId);
}
