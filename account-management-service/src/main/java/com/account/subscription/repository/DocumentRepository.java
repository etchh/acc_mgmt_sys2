package com.account.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.subscription.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}
