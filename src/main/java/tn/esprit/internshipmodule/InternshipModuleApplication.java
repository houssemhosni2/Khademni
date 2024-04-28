package tn.esprit.internshipmodule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.internshipmodule.entities.InternshipOffer;
import tn.esprit.internshipmodule.repositories.InternshipOfferRepository;
import tn.esprit.internshipmodule.service.InternshipOfferService;

@SpringBootApplication
public class InternshipModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipModuleApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner start(InternshipOfferRepository internshipOfferRepository,
								   InternshipOfferService internshipOfferService){
		return (args -> {
			InternshipOffer i = InternshipOffer.builder()
					.iContact("33333333")
					.iDescription("kenmou et les mata")
					.build();

			internshipOfferService.addOrUpdateInternshipOffer(i);
		});	*/
	//}

}
