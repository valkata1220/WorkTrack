package com.worktrack.worktrack.web.controllers;

import com.worktrack.worktrack.domain.models.binding.CompanyRegisterBindingModel;
import com.worktrack.worktrack.domain.models.service.CompanyServiceModel;
import com.worktrack.worktrack.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/compnay")
public class CompanyController extends BaseController {

    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@ModelAttribute CompanyRegisterBindingModel model){
        if(!model.getPassword().equals(model.getConfirmPassword())){
            return super.view("company-index");
        }

        this.companyService.registerCompany(this.modelMapper.map(model, CompanyServiceModel.class));

        return super.redirect("company-index");
    }
}
