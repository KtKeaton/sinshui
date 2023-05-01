package project.service;

import project.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {

    Optional<Position> findPositionByPositionName(String positionTypeName);

    List<String> findAllPositionTypeNames();

    List<Position> createPositions(List<String> positions);

    Position createPosition(String positionName);
}
