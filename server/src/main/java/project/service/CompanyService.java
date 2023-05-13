package project.service;

import project.data.CompanyCreateRequestData;
import project.model.Company;
import project.model.CompanyType;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<Company> findCompanyByCompanyName(String companyName);

    List<String> findAllCompanyNames();
    
    List<String> findByCompanyType(String companyType);

    Company createCompany(String companyName, CompanyType companyType);

    List<Company> createCompanies(List<CompanyCreateRequestData> companyNames);
}
