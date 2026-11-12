package org.hotl.libraryjpatesting.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hotl.libraryjpatesting.domain.enums.BookGenre;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue
    @Column(name="book_id", nullable = false, updatable = false, unique = true)
    private UUID bookId;

    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name="genre")
    private BookGenre genre;

    @Column(name="number_of_pages")
    private Integer numberOfPages;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorEntity> authors = new HashSet<>();




    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof BookEntity)) return false;
        BookEntity that = (BookEntity) o;
        return getBookId() != null && Objects.equals(getBookId(), that.getBookId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
