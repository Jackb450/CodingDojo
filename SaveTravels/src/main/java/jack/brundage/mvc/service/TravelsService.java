package jack.brundage.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jack.brundage.mvc.models.Travels;
import jack.brundage.mvc.repositories.TravelsRepository;

@Service
public class TravelsService {
	private final TravelsRepository TravelsRepository;
	
	public TravelsService(TravelsRepository TravelsRepository) {
		this.TravelsRepository = TravelsRepository;
	}
	public List<Travels> allExpense() {
        return TravelsRepository.findAll();
    }
    public Travels createExpense(Travels b) {
        return TravelsRepository.save(b);
    }
    public Travels updateExpense(Travels b) {
    	return TravelsRepository.save(b);
    }
    public void deleteExpense(long id) {
    	TravelsRepository.deleteById(id);
    }
    public Travels findExpense(Long id) {
        Optional<Travels> optionalExpense = TravelsRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        }
        else {
            return null;
        }
    }
}