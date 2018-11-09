package be.vyncke.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import be.vyncke.domain.*;

public interface HuurcontractRepository extends JpaRepository<Huurcontract, Integer> {
	Optional<List<Huurcontract>> findByBeginDatumBetweenAndEindDatumBetween(@Param("beginDatum1") Date begindatum1, @Param("EindDatum1") Date einddatum1,
			@Param("beginDatum2") Date begindatum2, @Param("eindDatum1") Date einddatum2);
	Optional<List<Huurcontract>> findByKlantId(@Param("klant") int klant);
}
