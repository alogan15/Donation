package com.logan.donations.domain.donation.controllers;

import com.logan.donations.domain.donation.models.Donation;
import com.logan.donations.domain.donation.services.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {
    private DonationService donationService;


    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public ResponseEntity<List<Donation>> getAll(){
        List<Donation> donations = donationService.getAll();
        return new ResponseEntity<>(donations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Donation> create(@RequestBody Donation donation){
        donation = donationService.create(donation);
        return new ResponseEntity<>(donation, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Donation> getById(@PathVariable("id") Long id){
        Donation donation = donationService.getById(id);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Donation> getByEmail(@RequestParam String email){
        Donation donation = donationService.getByEmail(email);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @GetMapping("lookupfullname")
    public ResponseEntity<Donation> getByFullName(@RequestParam String fullName){
        Donation donation = donationService.getByFullName(fullName);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @GetMapping("lookupfirstname")
    public ResponseEntity<Donation> getByFirstName(@RequestParam String firstName){
        Donation donation = donationService.getByEmail(firstName);
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Donation> update(@PathVariable("id") Long id, @RequestBody Donation donationDetail){
        donationDetail = donationService.update(id, donationDetail);
        return new ResponseEntity<>(donationDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        donationService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}




