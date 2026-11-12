package org.hotl.libraryjpatesting.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hotl.libraryjpatesting.domain.enums.Gender;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class AuthorEntity {


    @Id
    @GeneratedValue
    @Column(name = "author_id", nullable = false, updatable = false, unique = true)
    private UUID authorId;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;


    @Column(name="country")
    private String country;

    @Column(name="native_language")
    private String nativeLanguage;

    @ManyToMany(mappedBy = "authors")
    private Set<BookEntity> books = new HashSet<>();


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof AuthorEntity)) return false;
        AuthorEntity that = (AuthorEntity) o;
        return getAuthorId() != null && Objects.equals(getAuthorId(), that.getAuthorId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
