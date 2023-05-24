package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.data.PositionDetailCreateRequestData;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;
import project.mapper.PositionDetailMapper;
import project.model.Company;
import project.model.CompanyType;
import project.model.PositionDetail;
import project.model.Position;
import project.service.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final CompanyTypeService companyTypeService;
    private final CompanyService companyService;
    private final PositionService positionService;
    private final PositionDetailService positionDetailService;
    private final PositionDetailMapper positionDetailMapper = Mappers.getMapper(PositionDetailMapper.class);

    @Override
    @Transactional
    public List<PositionDetail> createPositionDetailWithApi(List<PositionDetailCreateRequestData> positionDetailCreateRequestDataList) {
        List<PositionDetail> result = new ArrayList<>();
        positionDetailCreateRequestDataList.forEach(positionDetailCreateRequestData -> {
            Position position = positionService.findPositionByPositionName(positionDetailCreateRequestData.getPosition())
                    .orElseThrow(() -> new GlobalRuntimeException(ResponseCode.POSITION_NOT_FOUND_ERROR));

            Company company = companyService.findByCompanyTypeAndCompanyName(positionDetailCreateRequestData.getCompanyType(), positionDetailCreateRequestData.getCompanyName().trim())
                    .orElseThrow(() -> new GlobalRuntimeException(ResponseCode.COMPANY_NOT_FOUND_ERROR));

            PositionDetail positionDetail = positionDetailMapper.requestDataToModel(positionDetailCreateRequestData);
            positionDetail.setPosition(position);
            positionDetail.setCompany(company);
            positionDetailCreateRequestData.setTimestamp(positionDetailCreateRequestData.getTimestamp().replace("上午", "AM"));
            positionDetailCreateRequestData.setTimestamp(positionDetailCreateRequestData.getTimestamp().replace("下午", "PM"));
            positionDetail.setTimestamp(
                    LocalDateTime.parse(positionDetailCreateRequestData.getTimestamp(),
                            DateTimeFormatter.ofPattern("yyyy/M/d a h:mm:ss", Locale.ENGLISH)));
            result.add(positionDetailService.createPositionDetail(positionDetail));
        });

        return result;
    }

    @Override
    @Transactional
    public PositionDetail createPositionDetailWithFile(PositionDetailCreateRequestData positionDetailCreateRequestData) {
        CompanyType companyType = companyTypeService.getOrCreateCompanyType(positionDetailCreateRequestData.getCompanyType().trim());

        Position position = positionService.findPositionByPositionName(positionDetailCreateRequestData.getPosition())
                .orElseGet(() -> positionService.createPosition(positionDetailCreateRequestData.getPosition()));

        Company company = companyService.findByCompanyTypeAndCompanyName(positionDetailCreateRequestData.getCompanyType(), positionDetailCreateRequestData.getCompanyName().trim())
                .orElseGet(() -> companyService.createCompany(positionDetailCreateRequestData.getCompanyName().trim(), companyType));

        PositionDetail positionDetail = positionDetailMapper.requestDataToModel(positionDetailCreateRequestData);
        positionDetail.setPosition(position);
        positionDetail.setCompany(company);
        if (!positionDetailCreateRequestData.getTimestamp().isEmpty()) {
            positionDetailCreateRequestData.setTimestamp(positionDetailCreateRequestData.getTimestamp().replace("上午", "AM"));
            positionDetailCreateRequestData.setTimestamp(positionDetailCreateRequestData.getTimestamp().replace("下午", "PM"));
            positionDetail.setTimestamp(
                    LocalDateTime.parse(positionDetailCreateRequestData.getTimestamp(),
                            DateTimeFormatter.ofPattern("yyyy/M/d a h:mm:ss", Locale.ENGLISH)));
        }

        return positionDetailService.createPositionDetail(positionDetail);
    }
}
