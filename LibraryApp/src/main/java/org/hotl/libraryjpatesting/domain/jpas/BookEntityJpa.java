package org.hotl.libraryjpatesting.domain.jpas;

import org.hotl.libraryjpatesting.domain.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookEntityJpa extends JpaRepository<BookEntity, UUID> {

    @EntityGraph(attributePaths = "authors")
    Page<BookEntity> findAll(Pageable pageable);

    List<BookEntity> findDistinctByAuthors_FirstName(String firstName);

    @EntityGraph(attributePaths = "authors")
    List<BookEntity> findAllByNumberOfPagesGreaterThan(Integer pages);

}
