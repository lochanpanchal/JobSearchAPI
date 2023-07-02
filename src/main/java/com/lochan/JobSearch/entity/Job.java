package com.lochan.JobSearch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 100)
    private String title;

    @NonNull
    @Size(min = 1, max = 500)
    private String description;

    @NonNull
    @Size(min = 1, max = 100)
    private String location;

    @Min(20000)
    private Double salary; //(hint @min for salary : should be above 20,000 )

    @NonNull
    @Email
    private String companyEmail;

    @NonNull
    @Size(min = 1, max = 100)
    private String companyName;

    @NonNull
    @Size(min = 1, max = 100)
    private String employerName;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Type jobType;

    private LocalDate appliedData;
}
