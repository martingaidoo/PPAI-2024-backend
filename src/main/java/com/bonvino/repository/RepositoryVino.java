package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Vino;

@Repository
public interface RepositoryVino extends JpaRepository<Vino, Long> {
}