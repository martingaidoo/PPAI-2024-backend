package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Resena;

@Repository
public interface RepositoryResena extends JpaRepository<Resena, Long> {

}
