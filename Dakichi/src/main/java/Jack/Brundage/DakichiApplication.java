package Jack.Brundage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/dakichi")
public class DakichiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DakichiApplication.class, args);
	}
	@RequestMapping("/travel/{location}")
	public String travel(@PathVariable("location") String location) {
		return "You won a trip to " + location + "!";
	}
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") int num) {
		if (num % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		else if (num % 2 == 1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		else {
			return "error: number not recongnized";
		}
	}
}
