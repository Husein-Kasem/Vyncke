package be.vyncke.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import be.vyncke.domain.*;

public interface AanvraagRepository extends JpaRepository<Aanvraag, Integer> {
	Optional<List<Aanvraag>> findByKlantId(@Param("klant") int klant);
}
