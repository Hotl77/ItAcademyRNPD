package org.hotl.libraryjpatesting.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hotl.libraryjpatesting.domain.enums.LoanStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
public class LoanEntity {


    @Id
    @GeneratedValue
    @Column(name="id",nullable = false, updatable = false, unique = true)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @CreationTimestamp
    @Column(name="loan_date")
    private LocalDateTime loanDate;

    @Column(name="due_date")
    private LocalDateTime dueDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name="loan_status")
    private LoanStatus loanStatus;


}
