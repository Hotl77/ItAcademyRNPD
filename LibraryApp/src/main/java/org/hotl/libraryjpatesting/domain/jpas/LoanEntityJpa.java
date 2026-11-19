package org.hotl.libraryjpatesting.domain.jpas;

import org.hotl.libraryjpatesting.domain.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanEntityJpa extends JpaRepository<LoanEntity, UUID> {
}
