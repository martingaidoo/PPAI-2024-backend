package com.bonvino;

import com.bonvino.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPais extends JpaRepository<Pais, Long> {

}
