package project.service;

import project.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<Company> findCompanyByCompanyName(String companyName);

    List<String> findAllCompanyNames();

    Company createCompany(String companyName);
}
