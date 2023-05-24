package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.data.CompanyCreateRequestData;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;
import project.model.Company;
import project.model.CompanyType;
import project.repository.CompanyDao;
import project.service.CompanyService;
import project.service.CompanyTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;
    private final CompanyTypeService companyTypeService;

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllCompanyNames() {
        return companyDao.findAll().stream().map(Company::getCompanyName).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findByCompanyType(String companyType) {
        return companyDao.getByCompanyType(companyType).stream().map(Company::getCompanyName).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Company> findByCompanyTypeAndCompanyName(String companyType, String companyName) {
        return companyDao.getByCompanyTypeAndCompanyName(companyType, companyName);
    }

    @Override
    @Transactional
    public Company createCompany(String companyName, CompanyType companyType) {
        return companyDao.save(Company.builder()
                .companyName(companyName)
                .companyType(companyType)
                .build());
    }

    @Override
    @Transactional
    public List<Company> createCompanies(List<CompanyCreateRequestData> companyNames) {
        List<Company> result = new ArrayList<>();

        Map<String, CompanyType> companyTypeMap = companyTypeService.getAllCompanyTypeMap();
        for (CompanyCreateRequestData data : companyNames) {
            if (!companyTypeMap.containsKey(data.getCompanyType())) {
                throw new GlobalRuntimeException(ResponseCode.COMPANY_TYPE_NOT_FOUND_ERROR);
            }
            result.add(Company.builder()
                    .companyName(data.getCompanyName())
                    .companyType(companyTypeMap.get(data.getCompanyType()))
                    .build());

        }

        try {
            result = companyDao.saveAll(result);
        } catch (Exception e) {
            throw new GlobalRuntimeException(ResponseCode.COMPANY_NAME_DUPLICATE_ERROR);
        }
        return result;
    }
}
