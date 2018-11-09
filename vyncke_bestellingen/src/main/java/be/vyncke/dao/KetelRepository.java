package be.vyncke.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import be.vyncke.domain.Ketel;

public interface KetelRepository extends JpaRepository<Ketel, Integer>  {

}
