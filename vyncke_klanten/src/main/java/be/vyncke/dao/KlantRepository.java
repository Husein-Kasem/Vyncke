package be.vyncke.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import be.vyncke.domain.*;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface KlantRepository extends JpaRepository<Klant, Integer> {
	Optional<List<Klant>> findByVoornaamStartingWith(@Param("voornaam") String voornaam);
	Optional<List<Klant>> findByNaamStartingWith(@Param("naam") String naam);
	Optional<List<Klant>> findByVoornaamStartingWithIgnoreCaseAndNaamStartingWithIgnoreCaseOrderByNaam
	(@Param("voornaam") String voornaam, @Param("naam") String naam);
}
