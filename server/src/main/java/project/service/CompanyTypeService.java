package project.service;

import project.data.CompanyTypeData;
import project.model.CompanyType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CompanyTypeService {
    CompanyType getOrCreateCompanyType(String companyType);

    List<CompanyType> createCompanyTypes(List<CompanyTypeData> companyTypeDataList);

    Optional<CompanyType> getCompanyType(String companyType);

    List<CompanyTypeData> getAllCompanyTypeDataList();

    Map<String, CompanyType> getAllCompanyTypeMap();
}
