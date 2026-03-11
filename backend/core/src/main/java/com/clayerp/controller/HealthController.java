package com.clayerp.controller;

import com.clayerp.dto.ApiResponse;
import com.clayerp.dto.HealthResponse;
import com.clayerp.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/api/health")
    public ApiResponse<HealthResponse> health() {

        HealthResponse hr = healthService.getHealthStatus();

        return new ApiResponse<>(true, hr);

    }

}
