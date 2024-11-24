package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Provincia;

@Repository
public interface RepositoryProvincia extends JpaRepository<Provincia, Long> {

}
