package org.hotl.libraryjpatesting.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(name="library_card_number")
    private String libraryCardNumber;

    @CreationTimestamp
    @Column(name="registration_date", nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    @Column(name="passport_series_and_number", nullable = false)
    private String passportSeriesAndNumber;

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true
    )
    private List<LoanEntity> loans = new ArrayList<>();

    public void addLoan(LoanEntity loan) {
        loans.add(loan);
        loan.setUser(this);
    }

    public void removeLoan(LoanEntity loan) {
        loans.remove(loan);
        loan.setUser(null);
    }

}
