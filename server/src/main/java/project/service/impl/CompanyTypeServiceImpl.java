package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.data.CompanyTypeData;
import project.model.CompanyType;
import project.repository.CompanyTypeDao;
import project.service.CompanyTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyTypeServiceImpl implements CompanyTypeService {

    private final CompanyTypeDao companyTypeDao;

    @Override
    @Transactional
    public CompanyType getOrCreateCompanyType(String companyType) {
        return companyTypeDao.findByTypeName(companyType)
                .orElseGet(() -> companyTypeDao.save(CompanyType.builder().typeName(companyType).build()));
    }

    @Override
    public List<CompanyType> createCompanyTypes(List<CompanyTypeData> companyTypeDataList) {
        List<CompanyType> result = new ArrayList<>();
        companyTypeDataList.forEach(data -> result.add(CompanyType.builder()
                .typeName(data.getCompanyType())
                .label(data.getLabel())
                .build()));
        return companyTypeDao.saveAll(result);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CompanyType> getCompanyType(String companyType) {
        return companyTypeDao.findByTypeName(companyType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyTypeData> getAllCompanyTypeDataList() {
        return companyTypeDao.findAll().stream()
                .map(data -> CompanyTypeData.builder()
                        .companyType(data.getTypeName())
                        .label(data.getLabel())
                        .build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, CompanyType> getAllCompanyTypeMap() {
        return companyTypeDao.findAll().stream()
                .collect(Collectors.toMap(CompanyType::getTypeName, Function.identity()));
    }
}
