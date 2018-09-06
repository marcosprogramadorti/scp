package br.gov.transportes.scp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


import br.gov.transportes.scp.config.property.ScpServiceProperty;




@SpringBootApplication
@EnableConfigurationProperties(ScpServiceProperty.class)
public class ScpApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ScpApplication.class, args);
	}
}
