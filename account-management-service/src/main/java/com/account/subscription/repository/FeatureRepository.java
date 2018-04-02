package com.account.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.subscription.entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long>{

}
