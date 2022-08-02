package com.logan.donations.domain.donation.services;

import com.logan.donations.domain.core.ResourceCreationException;
import com.logan.donations.domain.core.ResourceNotFoundException;
import com.logan.donations.domain.donation.models.Donation;
import com.logan.donations.domain.donation.models.DonationType;

import java.util.List;

public interface DonationService {
    Donation create(Donation donation) throws ResourceCreationException;
    Donation getById(Long Donation) throws ResourceNotFoundException;
    Donation getByEmail(String email) throws ResourceNotFoundException;
    Donation getByFullName(String fullName) throws ResourceNotFoundException;
    Donation getByFirstName(String firstName) throws ResourceNotFoundException;
    List<Donation> getByDonationType(DonationType donationType) throws ResourceNotFoundException;
    List<Donation> getAll();
    Donation update(Long id, Donation donationDetail) throws ResourceNotFoundException;
    void delete(Long id);
}