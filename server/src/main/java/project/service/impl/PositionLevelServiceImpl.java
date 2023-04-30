package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;
import project.model.PositionLevel;
import project.repository.PositionLevelDao;
import project.service.PositionLevelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionLevelServiceImpl implements PositionLevelService {

    private final PositionLevelDao positionLevelDao;

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllPositionLevelNames() {
        return positionLevelDao.findAll().stream().map(PositionLevel::getPositionLevelName).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PositionLevel findPositionLevelByName(String positionLevelName) {
        return positionLevelDao.findByPositionLevelName(positionLevelName)
                .orElseThrow(() -> new GlobalRuntimeException(ResponseCode.POSITION_LEVEL_NOT_FOUND_ERROR));
    }
}
