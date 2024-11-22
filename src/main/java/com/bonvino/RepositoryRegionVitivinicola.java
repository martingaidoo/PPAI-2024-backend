package com.bonvino;

import com.bonvino.RegionVitivinicola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRegionVitivinicola extends JpaRepository<RegionVitivinicola, Long> {

}
