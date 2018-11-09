package be.vyncke.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vyncke.domain.Functie;

public interface FunctieRepository extends JpaRepository<Functie, Integer> {
	
}
