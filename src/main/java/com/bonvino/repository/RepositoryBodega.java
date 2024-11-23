package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.Bodega;

@Repository
public interface RepositoryBodega extends JpaRepository<Bodega, Long> {

}

