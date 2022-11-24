package jack.brundage.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jack.brundage.mvc.models.books;

@Repository
public interface bookRepository extends CrudRepository<books, Long> {
    List<books> findAll();
    List<books> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
