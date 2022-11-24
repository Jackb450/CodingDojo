package jack.brundage.mvc.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import jack.brundage.mvc.models.Login;
import jack.brundage.mvc.models.Users;
import jack.brundage.mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private final UserRepository UserRep;
	
	public UserService(UserRepository UserRep) {
		this.UserRep = UserRep;
	}
	public List<Users> allUsers() {
		return UserRep.findAll();
	}
	public Users createUser(Users u, BindingResult result) {
		if (UserRep.findByEmail(u.getEmail()).isPresent()) {
			result.rejectValue("email", "Email already in use");
		}
		if (!u.getPassword().equals(u.getConfirm())) {
			result.rejectValue("confirm", "Password's must match");
		}
		if (result.hasErrors()) {
			return null;
		}
		else {
			String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
			u.setPassword(hashed);
			return UserRep.save(u);
		}
	}
	public Users loginUser(Login l, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<Users> User = UserRep.findByEmail(l.getEmail());
		if (!User.isPresent()) {
			result.rejectValue("email", "unknown email");
			return null;
		}
		Users user = User.get();
		if (!BCrypt.checkpw(l.getPassword(), user.getPassword()) ) {
			result.rejectValue("password", "Password not correct");
		}
		if (result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
	}
	public Users updateUser(Users u) {
		return UserRep.save(u);
	}
	public void deleteUser(long id) {
		UserRep.deleteById(id);
	}
	public Users findUser(Long id) {
		Optional<Users> optionalUser = UserRep.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
}
