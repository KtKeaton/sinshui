package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.CompanyType;
import project.repository.CompanyTypeDao;
import project.service.CompanyTypeService;

@Service
@RequiredArgsConstructor
public class CompanyTypeServiceImpl implements CompanyTypeService {

    private final CompanyTypeDao companyTypeDao;

    private static final String SOFTWARE = "software";

    @Override
    public CompanyType getSoftwareCompany() {
        return companyTypeDao.findByTypeName(SOFTWARE)
                .orElseGet(() -> companyTypeDao.save(CompanyType.builder().typeName(SOFTWARE).build()));
    }
}
