package com.eqinov.recrutement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eqinov.recrutement.data.Site;

import java.util.Optional;

public interface SiteRepository extends JpaRepository<Site, Long> {
}