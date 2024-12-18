package com.legacy.gli.service;

import com.legacy.gli.model.Listings;
import com.legacy.gli.repository.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingsService {

    private final ListingsRepository listingsRepository;

    @Autowired
    public ListingsService(ListingsRepository listingsRepository) {
        this.listingsRepository = listingsRepository;
    }

    // Get all listings
    public List<Listings> getAllListings() {
        return listingsRepository.findAll();
    }

    // Get listing by ID
    public Optional<Listings> getListingById(Integer id) {
        return listingsRepository.findById(id);
    }

    // Save or update a listing
    public Listings saveListing(Listings listing) {
        return listingsRepository.save(listing);
    }

    // Delete listing by ID
    public boolean deleteListing(Integer id) {
        if (listingsRepository.existsById(id)) {
            listingsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Find listings by company ID
    public List<Listings> getListingsByCompanyId(Integer companyId) {
        return listingsRepository.findByCompanyCompanyId(companyId);
    }

    // Find listings by category
    public List<Listings> getListingsByCategory(String category) {
        return listingsRepository.findByCategory(category);
    }

    // Find listings by location
    public List<Listings> getListingsByLocation(String location) {
        return listingsRepository.findByLocation(location);
    }

    // Find listings by type
    public List<Listings> getListingsByType(String listingType) {
        return listingsRepository.findByListingType(listingType);
    }
}
