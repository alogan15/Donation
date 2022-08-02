package com.logan.donations.domain.donation.repos;

import com.logan.donations.domain.donation.models.Donation;
import com.logan.donations.domain.donation.models.DonationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    Optional<Donation> findByEmail(String email);
    List<Donation> findByLastName(String lastName);
    List<Donation> findByDonationType(DonationType donationType);

}
