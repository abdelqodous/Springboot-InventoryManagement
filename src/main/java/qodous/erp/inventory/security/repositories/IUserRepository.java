package qodous.erp.inventory.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import qodous.erp.inventory.security.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
