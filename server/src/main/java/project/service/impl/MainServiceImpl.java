package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.data.PositionDetailCreateRequestData;
import project.mapper.PositionDetailMapper;
import project.model.Company;
import project.model.PositionDetail;
import project.model.PositionLevel;
import project.model.PositionType;
import project.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final CompanyService companyService;
    private final PositionLevelService positionLevelService;
    private final PositionTypeService positionTypeService;
    private final PositionDetailService positionDetailService;
    private final PositionDetailMapper positionDetailMapper = Mappers.getMapper(PositionDetailMapper.class);

    @Override
    @Transactional
    public List<PositionDetail> createPositionDetail(List<PositionDetailCreateRequestData> positionDetailCreateRequestDataList) {
        List<PositionDetail> result = new ArrayList<>();
        positionDetailCreateRequestDataList.forEach(positionDetailCreateRequestData -> {
            PositionType positionType = positionTypeService.findPositionTypeByName(positionDetailCreateRequestData.getPositionType());
            PositionLevel positionLevel = positionLevelService.findPositionLevelByName(positionDetailCreateRequestData.getPositionLevel());
            String companyName = positionDetailCreateRequestData.getCompanyName().trim();
            Optional<Company> companyOpt = companyService.findCompanyByCompanyName(companyName);
            Company company = companyOpt.isEmpty() ? companyService.createCompany(companyName) : companyOpt.get();

            PositionDetail positionDetail = positionDetailMapper.requestDataToModel(positionDetailCreateRequestData);
            positionDetail.setPositionType(positionType);
            positionDetail.setPositionLevel(positionLevel);
            positionDetail.setCompany(company);
            result.add(positionDetailService.createPositionDetail(positionDetail));
        });

        return result;
    }
}
