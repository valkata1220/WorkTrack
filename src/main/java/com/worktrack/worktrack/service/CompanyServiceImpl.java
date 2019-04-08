package com.worktrack.worktrack.service;

import com.worktrack.worktrack.domain.entities.Company;
import com.worktrack.worktrack.domain.models.service.CompanyServiceModel;
import com.worktrack.worktrack.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, RoleService roleService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.companyRepository = companyRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public CompanyServiceModel registerCompany(CompanyServiceModel companyServiceModel) {
        this.roleService.seedRolesInDb();
        if(this.companyRepository.count() == 0){
            companyServiceModel.setAuthorities(this.roleService.findAllRoles());
        }else{
            companyServiceModel.setAuthorities(new LinkedHashSet<>());
            companyServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_COMPANY"));
        }

        Company company = this.modelMapper.map(companyServiceModel,Company.class);
        company.setPassword(this.bCryptPasswordEncoder.encode(companyServiceModel.getPassword()));

        return this.modelMapper.map(this.companyRepository.saveAndFlush(company),CompanyServiceModel.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.companyRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }
}
