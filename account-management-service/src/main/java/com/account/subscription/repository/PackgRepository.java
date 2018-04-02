package com.account.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.subscription.entity.Packg;

@Repository
public interface PackgRepository extends JpaRepository<Packg, Long>{

}
