package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;
import project.model.Position;
import project.repository.PositionDao;
import project.service.PositionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionDao positionDao;


    @Override
    @Transactional(readOnly = true)
    public Optional<Position> findPositionByPositionName(String positionName) {
        return positionDao.findByPositionName(positionName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findAllPositionTypeNames() {
        return positionDao.findAll().stream().map(Position::getPositionName).toList();
    }

    @Override
    @Transactional
    public List<Position> createPositions(List<String> positions) {
        List<Position> result = new ArrayList<>();
        for (String position : positions) {
            try {
                result.add(positionDao.save(Position.builder().positionName(position).build()));
            } catch (Exception e) {
                throw new GlobalRuntimeException(ResponseCode.POSITION_DUPLICATE_ERROR);
            }
        }
        return result;
    }

    @Override
    @Transactional
    public Position createPosition(String positionName) {
        return positionDao.save(Position.builder().positionName(positionName).build());
    }
}
