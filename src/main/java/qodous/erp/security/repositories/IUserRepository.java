package qodous.erp.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import qodous.erp.security.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	Optional<UserDetails> findByUserName(String userName);
}
