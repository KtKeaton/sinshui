package project.service;

import project.model.PositionType;

import java.util.List;

public interface PositionTypeService {

    PositionType findPositionTypeByName(String positionTypeName);

    List<String> findAllPositionTypeNames();
}
