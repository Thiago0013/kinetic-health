package com.kinetichealth.backendcore.controller;

import com.kinetichealth.backendcore.dto.HydrationLogsDTO;
import com.kinetichealth.backendcore.models.HydrationLogs;
import com.kinetichealth.backendcore.models.Users;
import com.kinetichealth.backendcore.services.HydrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hydration")
public class HydrationController {

    private final HydrationService hydrationService;

    public HydrationController(HydrationService hydrationService){
        this.hydrationService = hydrationService;
    }

    @GetMapping
    public ResponseEntity<List<HydrationLogs>> getHydration(@AuthenticationPrincipal Users user){
        List<HydrationLogs> logs = hydrationService.getHydrationLogs(user);

        return ResponseEntity.ok(logs);
    }

    @PostMapping
    public ResponseEntity<HydrationLogs> postHydration(@RequestBody HydrationLogsDTO dto, @AuthenticationPrincipal Users user){
        HydrationLogs hydration = hydrationService.saveHydrationLogs(dto, user);

        return ResponseEntity.ok(hydration);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delHydration(@PathVariable UUID id, @AuthenticationPrincipal Users user){
        hydrationService.deleteHydrationLogs(id, user);
        return ResponseEntity.noContent().build();
    }
}
