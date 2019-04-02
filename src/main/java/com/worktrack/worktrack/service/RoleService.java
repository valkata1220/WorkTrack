package com.worktrack.worktrack.service;

import com.worktrack.worktrack.domain.models.service.CompanyServiceModel;

public interface RoleService {

    void seedRolesInDb();

    void assignCompanyRoles(CompanyServiceModel companyServiceModel);
}
