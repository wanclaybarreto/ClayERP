package com.clayerp.service;

import com.clayerp.domain.Establishment;
import com.clayerp.domain.RestaurantTable;
import com.clayerp.dto.CreateRestaurantTableRequest;
import com.clayerp.dto.CreateRestaurantTableResponse;
import com.clayerp.exception.NotFoundException;
import com.clayerp.exception.RuleViolationException;
import com.clayerp.repository.EstablishmentRepository;
import com.clayerp.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final EstablishmentRepository establishmentRepository;

    public RestaurantTableService(
            RestaurantTableRepository restaurantTableRepository,
            EstablishmentRepository establishmentRepository
    ) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.establishmentRepository = establishmentRepository;
    }

    public CreateRestaurantTableResponse createRestaurantTable(CreateRestaurantTableRequest crtRequest) {
        Establishment establishment = establishmentRepository
                .findById(crtRequest.getEstablishmentId())
                .orElseThrow(() -> new NotFoundException("restaurant.notfound"));

        boolean exists = restaurantTableRepository.existsByEstablishmentIdAndNumber(
                establishment.getId(),
                crtRequest.getNumber()
        );

        if (exists) {
            throw new RuleViolationException(
                    "restaurant.table.number.already.exists",
                    crtRequest.getNumber()
            );
        }

        RestaurantTable table = new RestaurantTable();
        table.setEstablishment(establishment);
        table.setNumber(crtRequest.getNumber());
        table.setActive(true);

        restaurantTableRepository.save(table);

        return new CreateRestaurantTableResponse(
                table.getId(),
                table.getNumber(),
                table.getQrCode()
        );
    }
}
