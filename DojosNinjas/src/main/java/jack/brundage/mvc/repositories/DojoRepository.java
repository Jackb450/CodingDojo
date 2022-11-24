package jack.brundage.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jack.brundage.mvc.models.Dojos;

@Repository
public interface DojoRepository extends CrudRepository<Dojos, Long> {
	List<Dojos> findAll();
	List<Dojos> findByNameContaining(String search);
    Long countByNameContaining(String search);
    Long deleteByNameStartingWith(String search);
}
