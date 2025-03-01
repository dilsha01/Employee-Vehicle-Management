package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BikeEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bikeEmployeeId;

    private String name;
    private String contactNo;
    private String email;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "enteredBy", nullable = false)
    private OtherEmployee enteredBy;

    private LocalDateTime enteredDate;
}
