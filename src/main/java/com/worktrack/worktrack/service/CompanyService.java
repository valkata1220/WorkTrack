package com.worktrack.worktrack.service;

import com.worktrack.worktrack.domain.models.service.CompanyServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CompanyService extends UserDetailsService {

    CompanyServiceModel registerCompany(CompanyServiceModel companyServiceModel);
}
