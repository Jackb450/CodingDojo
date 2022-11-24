package jack.brundage.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jack.brundage.mvc.models.Ninjas;

@Repository
public interface NinjaRepository extends CrudRepository<Ninjas, Long> {
	List<Ninjas> findAll();
	List<Ninjas> findByfNameContaining(String search);
    Long countByfNameContaining(String search);
    Long deleteByfNameStartingWith(String search);
}