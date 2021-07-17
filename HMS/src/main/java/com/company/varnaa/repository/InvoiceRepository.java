package com.company.varnaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.varnaa.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

}