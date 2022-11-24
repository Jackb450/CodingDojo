package Jack.Brundage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
	@RequestMapping("/")
	public String Index() {
		return "Main";
	}
	@RequestMapping("/hello")
	public String Test() {
		return "Hello World!";
	}
	@RequestMapping("/today")
	public String Today() {
		return "Today";
	}
	@RequestMapping("/tomorrow")
	public String Tomorrow() {
		return "Tomorrow";
	}
	@RequestMapping("/query")
    public String Query(@RequestParam(value="q", required=false) String searchQuery) {
        return "You searched for: " + searchQuery;
    }
	@RequestMapping("/variable/{test1}/{test2}/{test3}")
	public String Variable(@PathVariable("test1") String test1, @PathVariable("test2") String test2, @PathVariable("test3") String test3) {
		return "Test1: " + test1 + ", test2: " + test2 + ", test3: " + test3;
	}
	@RequestMapping("")
	public String Main() {
		return "Main";
	}
}
