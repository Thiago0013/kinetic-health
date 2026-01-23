package com.kinetichealth.backendcore.services;

import com.kinetichealth.backendcore.dto.HydrationLogsDTO;
import com.kinetichealth.backendcore.models.HydrationLogs;
import com.kinetichealth.backendcore.models.Users;
import com.kinetichealth.backendcore.repository.HydrationLogsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class HydrationService {

    private final HydrationLogsRepository hydrationLogsRepo;

    public HydrationService(HydrationLogsRepository hydrationLogsRepo){
        this.hydrationLogsRepo = hydrationLogsRepo;
    }

    public List<HydrationLogs> getHydrationLogs(Users user){
        return hydrationLogsRepo.findAllByUser(user);
    }

    public HydrationLogs saveHydrationLogs(HydrationLogsDTO dto, Users user){
        HydrationLogs newHydration = HydrationLogs.builder()
                .user(user)
                .amountMl(dto.amountML())
                .consumedAt(LocalDateTime.now())
                .build();

        return hydrationLogsRepo.save(newHydration);
    }

    public void deleteHydrationLogs(UUID id, Users user){
        HydrationLogs log = hydrationLogsRepo.findById(id).orElseThrow(() -> new RuntimeException("ERRO: Log não encontrado!"));

        if(!log.getUser().getId().equals(user.getId())){
            throw new RuntimeException("ERRO: Esta log não pertece a você!");
        }
        hydrationLogsRepo.delete(log);
    }
}
