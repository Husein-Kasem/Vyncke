package be.vyncke;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import be.vyncke.domain.Functie;
import be.vyncke.domain.Personeel;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) { 
		config.exposeIdsFor(Personeel.class);
		config.exposeIdsFor(Functie.class);
	}
}
