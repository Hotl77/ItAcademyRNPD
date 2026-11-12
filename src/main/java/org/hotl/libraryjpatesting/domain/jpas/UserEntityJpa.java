package org.hotl.libraryjpatesting.domain.jpas;

import org.hotl.libraryjpatesting.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityJpa extends JpaRepository<UserEntity, UUID> {
}
