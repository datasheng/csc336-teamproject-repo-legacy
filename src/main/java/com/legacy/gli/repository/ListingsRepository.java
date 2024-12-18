package com.legacy.gli.repository;

import com.legacy.gli.model.Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingsRepository extends JpaRepository<Listings, Integer> {

    List<Listings> findByCompanyCompanyId(Integer companyId);

    List<Listings> findByCategory(String category);

    List<Listings> findByLocation(String location);

    List<Listings> findByListingType(String listingType);
}
