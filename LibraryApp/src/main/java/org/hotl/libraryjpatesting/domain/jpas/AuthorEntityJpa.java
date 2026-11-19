package org.hotl.libraryjpatesting.domain.jpas;

import org.hotl.libraryjpatesting.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorEntityJpa extends JpaRepository<AuthorEntity, UUID> {
}
