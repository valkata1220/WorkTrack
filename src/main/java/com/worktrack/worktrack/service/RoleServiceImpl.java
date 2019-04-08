package com.worktrack.worktrack.service;

import com.worktrack.worktrack.domain.entities.Role;
import com.worktrack.worktrack.domain.models.service.CompanyServiceModel;
import com.worktrack.worktrack.domain.models.service.RoleServiceModel;
import com.worktrack.worktrack.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedRolesInDb() {
        if(this.roleRepository.count() == 0){
            this.roleRepository.saveAndFlush(new Role("ROLE_COMPANY"));
            this.roleRepository.saveAndFlush(new Role("ROLE_WORKER"));
            this.roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));
            this.roleRepository.saveAndFlush(new Role("ROLE_ROOT"));
        }
    }

//    @Override
//    public void assignCompanyRoles(CompanyServiceModel companyServiceModel,long numberOfUsers) {
//        if(numberOfUsers == 0 ){
//            companyServiceModel
//                    .setAuthorities(this.roleRepository.findAll()
//                                    .stream()
//                                    .map(role -> this.modelMapper.map(role, RoleServiceModel.class))
//                                    .collect(Collectors.toSet()));
//        }
//    }


    @Override
    public Set<RoleServiceModel> findAllRoles() {
        return this.roleRepository.findAll().stream()
                .map(role -> this.modelMapper.map(role,RoleServiceModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public RoleServiceModel findByAuthority(String authority) {
        return this.modelMapper.map(authority,RoleServiceModel.class);
    }
}
