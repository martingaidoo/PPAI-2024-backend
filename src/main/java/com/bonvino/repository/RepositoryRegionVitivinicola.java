package com.bonvino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bonvino.model.RegionVitivinicola;

@Repository
public interface RepositoryRegionVitivinicola extends JpaRepository<RegionVitivinicola, Long> {

}