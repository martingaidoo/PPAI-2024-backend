package com.bonvino;

import com.bonvino.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProvincia extends JpaRepository<Provincia, Long> {

}
