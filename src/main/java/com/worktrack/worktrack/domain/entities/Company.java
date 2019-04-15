package com.worktrack.worktrack.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company extends BaseUserEntity {

    private String companyName;
    private JobArea jobArea;
    private String logo;

    @Column(name = "company_name",nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "job_area",nullable = false)
    public JobArea getJobArea() {
        return jobArea;
    }

    public void setJobArea(JobArea jobArea) {
        this.jobArea = jobArea;
    }

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
