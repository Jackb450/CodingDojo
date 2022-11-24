package jack.brundage.mvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jack.brundage.mvc.models.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
	List<Users> findAll();
	List<Users> findByEmailContaining(String search);
	Optional<Users> findByEmail(String email);
	Long countByEmailContaining(String search);
    Long deleteByEmailStartingWith(String search);
}