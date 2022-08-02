package com.logan.donations.domain.donation.services;

import com.logan.donations.domain.core.ResourceCreationException;
import com.logan.donations.domain.core.ResourceNotFoundException;
import com.logan.donations.domain.donation.models.Donation;
import com.logan.donations.domain.donation.models.DonationType;
import com.logan.donations.domain.donation.repos.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService{
    private DonationRepository donationRepository;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation create(Donation donation) throws ResourceCreationException {
        Optional<Donation> optional = donationRepository.findByEmail(donation.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Donor with email exists: " + donation.getEmail());
        donation = donationRepository.save(donation);
        return donation;
    }

    @Override
    public Donation getById(Long id) throws ResourceNotFoundException {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No donor with id: " + id));
        return donation;
    }

    @Override
    public Donation getByEmail(String email) throws ResourceNotFoundException {
        Donation donation = donationRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No donor with email: " + email));
        return donation;
    }

    @Override
    public Donation getByFullName(String fullName) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Donation getByFirstName(String firstName) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Donation> getByDonationType(DonationType donationType) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation update(Long id, Donation donationDetail) throws ResourceNotFoundException {
        Donation donation = getById(id);
        donation.setFirstName(donationDetail.getFirstName());
        donation.setLastName(donationDetail.getLastName());
        donation.setEmail(donationDetail.getEmail());
        donation = donationRepository.save(donation);
        donation.setQuantity(donationDetail.getQuantity());
        //donation.setDropOffDate(donationDetail.getDropOffDate());
        return donation;
    }

    @Override
    public void delete(Long id) {
        Donation donation = getById(id);
        donationRepository.delete(donation);
    }
}
