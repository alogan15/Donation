package com.logan.donations.domain.donation.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // parameterized constructor
@Data // getters and setters
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String fullName;

    @NonNull
    private String email;

    @NonNull
    private int quantity;

//    @NonNull
//    private Date dropOffDate;

    @NonNull
    private DonationType donationType;

    public String toString(){
        return String.format("%d %s %s %s %s %s", id, firstName,lastName, email, quantity, donationType);
    }
}
