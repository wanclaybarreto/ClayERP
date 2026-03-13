package com.clayerp.service;

import com.clayerp.domain.Establishment;
import com.clayerp.domain.RestaurantTable;
import com.clayerp.dto.CreateRestaurantTableRequest;
import com.clayerp.dto.CreateRestaurantTableResponse;
import com.clayerp.repository.EstablishmentRepository;
import com.clayerp.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final EstablishmentRepository establishmentRepository;
    private final MessageService messageService;

    public RestaurantTableService(
            RestaurantTableRepository restaurantTableRepository, EstablishmentRepository establishmentRepository,
            MessageService messageService
    ) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.establishmentRepository = establishmentRepository;
        this.messageService = messageService;
    }

    public CreateRestaurantTableResponse createRestaurantTable(CreateRestaurantTableRequest crtRequest) {
        Establishment establishment = establishmentRepository
                .findById(crtRequest.getEstablishmentId())
                .orElseThrow(() -> new RuntimeException(messageService.get("restaurant.notfound")));

        RestaurantTable table = new RestaurantTable();
        table.setEstablishment(establishment);
        table.setNumber(crtRequest.getNumber());

        restaurantTableRepository.save(table);

        return new CreateRestaurantTableResponse(
                table.getId(),
                table.getNumber(),
                table.getQrCode()
        );
    }
}
