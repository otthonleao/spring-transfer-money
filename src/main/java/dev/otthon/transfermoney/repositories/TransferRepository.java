package dev.otthon.transfermoney.repositories;

import dev.otthon.transfermoney.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
