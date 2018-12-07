package edu.phoenixRisers.RecipeBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class RecipeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}
	
	@GetMapping("/index")
    public String indexPage() {
        return "index";
    }
}




