package be.vyncke.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import be.vyncke.domain.Personeel;

public interface PersoneelRepository extends JpaRepository<Personeel, Integer>{
	Optional<List<Personeel>> findByVoornaamStartingWith(@Param("voornaam") String voornaam);
	Optional<List<Personeel>> findByNaamStartingWith(@Param("naam") String naam);
	Optional<List<Personeel>> findByVoornaamStartingWithIgnoreCaseAndNaamStartingWithIgnoreCaseOrderByNaam
	(@Param("voornaam") String voornaam, @Param("naam") String naam);
}
