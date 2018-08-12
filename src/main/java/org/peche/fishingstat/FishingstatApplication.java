package org.peche.fishingstat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class FishingstatApplication {
//	private static final Logger log = LoggerFactory.getLogger(FishingstatApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FishingstatApplication.class, args);
	}

}
