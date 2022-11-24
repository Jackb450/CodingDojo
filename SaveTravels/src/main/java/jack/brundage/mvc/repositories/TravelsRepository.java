package jack.brundage.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jack.brundage.mvc.models.Travels;

@Repository
public interface TravelsRepository extends CrudRepository<Travels, Long> {
	List<Travels> findAll();
	List<Travels> findByDescriptionContaining(String search);
    Long countByExpenseContaining(String search);
    Long deleteByExpenseStartingWith(String search);
}
