package demo.rest;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> helloUser(Principal principal) {
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("username", principal.getName());
		return result;
	}
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public String greetings() {
		return "Hello world";
	}

}
