package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.HydrationLogs;
import com.kinetichealth.backendcore.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HydrationLogsRepository extends JpaRepository<HydrationLogs, UUID> {

    List<HydrationLogs> findAllByUser(Users user);
}
