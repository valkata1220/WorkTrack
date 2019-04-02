package com.worktrack.worktrack.repository;

import com.worktrack.worktrack.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {

    Optional<Company> findByUsername(String username);
}
