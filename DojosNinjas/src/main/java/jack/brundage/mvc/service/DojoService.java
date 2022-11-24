package jack.brundage.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jack.brundage.mvc.models.Dojos;
import jack.brundage.mvc.models.Ninjas;
import jack.brundage.mvc.repositories.DojoRepository;
import jack.brundage.mvc.repositories.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository DojoRep;
	private final NinjaRepository NinjaRep;
	
	public DojoService(DojoRepository DojoRep, NinjaRepository NinjaRep) {
		this.DojoRep = DojoRep;
		this.NinjaRep = NinjaRep;
	}
	public List<Dojos> allDojos() {
        return DojoRep.findAll();
    }
	public List<Ninjas> allNinjas() {
		return NinjaRep.findAll();
	}
    public Dojos createDojo(Dojos d) {
        return DojoRep.save(d);
    }
    public Ninjas createNinja(Ninjas n) {
    	return NinjaRep.save(n);
    }
    public Dojos updateDojo(Dojos d) {
    	return DojoRep.save(d);
    }
    public Ninjas updateNinja(Ninjas n) {
    	return NinjaRep.save(n);
    }
    public void deleteDojo(long id) {
    	DojoRep.deleteById(id);
    }
    public void deleteNinja(long id) {
    	NinjaRep.deleteById(id);
    }
    public Dojos findDojo(Long id) {
        Optional<Dojos> optionalDojo = DojoRep.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        }
        else {
            return null;
        }
    }
    public Ninjas findNinja(Long id) {
    	Optional<Ninjas> optionalNinja = NinjaRep.findById(id);
    	if(optionalNinja.isPresent()) {
    		return optionalNinja.get();
    	}
    	else {
    		return null;
    	}
    }
}