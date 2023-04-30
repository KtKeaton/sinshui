package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Company;
import project.repository.CompanyDao;
import project.service.CompanyService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

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
        return companyDao.save(Company.builder().companyName(companyName).build());
    }
}
