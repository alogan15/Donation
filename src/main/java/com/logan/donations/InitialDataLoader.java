package com.logan.donations;

import com.logan.donations.domain.donation.models.Donation;
import com.logan.donations.domain.donation.models.DonationType;
import com.logan.donations.domain.donation.services.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private DonationService donationService;

    @Override
    public void run(String...args) throws Exception {
        Donation donation = new Donation("Andre", "Logan", "Andre Logan","andre@codediff.com", 1, DonationType.PERISHABLES);
        donation = donationService.create(donation);
        log.info("Created a new donation" + donation.toString());
    }
}
