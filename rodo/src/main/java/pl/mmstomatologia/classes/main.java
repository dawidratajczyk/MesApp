package pl.mmstomatologia.classes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main {
	
	@GetMapping("/main")
	public String welcomeView() {
		
		
		return("main");
	}

}
