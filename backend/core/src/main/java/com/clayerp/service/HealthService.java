package com.clayerp.service;

import com.clayerp.dto.HealthResponse;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    private MessageService messageService;

    public HealthService(MessageService messageService) {
        this.messageService = messageService;
    }

    public HealthResponse getHealthStatus() {

        return new HealthResponse(
                messageService.get("api.service.status"),
                messageService.get("api.service.name"),
                "0.1.0"
        );

    }

}
