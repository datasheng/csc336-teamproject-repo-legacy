package com.legacy.gli.controller;

import com.legacy.gli.model.Listings;
import com.legacy.gli.service.ListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listings")
public class ListingsController {

    private final ListingsService listingsService;

    @Autowired
    public ListingsController(ListingsService listingsService) {
        this.listingsService = listingsService;
    }

    // Get all listings
    @GetMapping
    public ResponseEntity<List<Listings>> getAllListings() {
        List<Listings> listings = listingsService.getAllListings();
        return new ResponseEntity<>(listings, HttpStatus.OK);
    }

    // Get listing by ID
    @GetMapping("/{id}")
    public ResponseEntity<Listings> getListingById(@PathVariable Integer id) {
        Optional<Listings> listing = listingsService.getListingById(id);
        return listing.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update a listing
    @PostMapping
    public ResponseEntity<Listings> createOrUpdateListing(@RequestBody Listings listing) {
        Listings savedListing = listingsService.saveListing(listing);
        return new ResponseEntity<>(savedListing, HttpStatus.CREATED);
    }

    // Delete a listing by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable Integer id) {
        boolean deleted = listingsService.deleteListing(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get listings by company ID
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Listings>> getListingsByCompanyId(@PathVariable Integer companyId) {
        List<Listings> listings = listingsService.getListingsByCompanyId(companyId);
        return new ResponseEntity<>(listings, HttpStatus.OK);
    }

    // Get listings by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Listings>> getListingsByCategory(@PathVariable String category) {
        List<Listings> listings = listingsService.getListingsByCategory(category);
        return new ResponseEntity<>(listings, HttpStatus.OK);
    }

    // Get listings by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Listings>> getListingsByLocation(@PathVariable String location) {
        List<Listings> listings = listingsService.getListingsByLocation(location);
        return new ResponseEntity<>(listings, HttpStatus.OK);
    }

    // Get listings by type
    @GetMapping("/type/{listingType}")
    public ResponseEntity<List<Listings>> getListingsByType(@PathVariable String listingType) {
        List<Listings> listings = listingsService.getListingsByType(listingType);
        return new ResponseEntity<>(listings, HttpStatus.OK);
    }
}
