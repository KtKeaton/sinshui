package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;
import project.model.Company;
import project.repository.CompanyDao;
import project.service.CompanyService;
import project.service.CompanyTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    private final CompanyTypeService companyTypeService;

    @Override
    @Transactional(readOnly = true)
    public Optional<Company> findCompanyByCompanyName(String companyName) {
        return companyDao.findByCompanyName(companyName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllCompanyNames() {
        return companyDao.findAll().stream().map(Company::getCompanyName).toList();
    }

    @Override
    @Transactional
    public Company createCompany(String companyName) {
        return companyDao.save(Company.builder()
                .companyName(companyName)
                .companyType(companyTypeService.getSoftwareCompany())
                .build());
    }

    @Override
    @Transactional
    public List<Company> createCompanies(List<String> companyNames) {
        List<Company> result = new ArrayList<>();
        for (String name : companyNames) {
            try {
                result.add(createCompany(name));
            } catch (Exception e) {
                throw new GlobalRuntimeException(ResponseCode.COMPANY_NAME_DUPLICATE_ERROR);
            }
        }
        return result;
    }
}
