package com.worktrack.worktrack.service;

import com.worktrack.worktrack.domain.models.service.CompanyServiceModel;
import com.worktrack.worktrack.domain.models.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

//    void assignCompanyRoles(CompanyServiceModel companyServiceModel,long numberOfUsers);

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);
}
