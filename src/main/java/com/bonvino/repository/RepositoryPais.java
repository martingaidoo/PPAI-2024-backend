package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Pais;

@Repository
public interface RepositoryPais extends JpaRepository<Pais, Long> {

}
