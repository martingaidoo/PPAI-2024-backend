package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Vino;
import java.util.List;

@Repository
public interface RepositoryVino extends JpaRepository<Vino, Long> {
}