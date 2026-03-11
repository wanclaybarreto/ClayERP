package com.clayerp.service;

import com.clayerp.dto.HealthResponse;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public HealthResponse getHealthStatus() {

        return new HealthResponse(
                "UP",
                "ClayERP API",
                "0.1.0"
        );

    }

}
