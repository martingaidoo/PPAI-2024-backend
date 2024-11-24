package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Varietal;

@Repository
public interface RepositoryVarietal extends JpaRepository<Varietal, Long> {

}