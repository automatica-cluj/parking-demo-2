package ro.utcluj.aut.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcluj.aut.parking.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
