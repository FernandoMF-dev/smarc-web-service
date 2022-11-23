package br.com.ifes.com.smarc.obesidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SmarcAgenteDeObesidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmarcAgenteDeObesidadeApplication.class, args);
	}

}
