package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;
import project.model.PositionType;
import project.repository.PositionTypeDao;
import project.service.PositionTypeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionTypeServiceImpl implements PositionTypeService {

    private final PositionTypeDao positionTypeDao;


    @Override
    @Transactional(readOnly = true)
    public PositionType findPositionTypeByName(String positionTypeName) {
        return positionTypeDao.findByPositionTypeName(positionTypeName)
                .orElseThrow(() -> new GlobalRuntimeException(ResponseCode.POSITION_TYPE_NOT_FOUND_ERROR));
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllPositionTypeNames() {
        return positionTypeDao.findAll().stream().map(PositionType::getPositionTypeName).toList();
    }
}
