package com.clayerp.repository;

import com.clayerp.domain.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    boolean existsByEstablishmentIdAndNumber(Long establishmentId, Integer number);

}
