package project.service;

import project.model.PositionLevel;

import java.util.List;

public interface PositionLevelService {
    List<String> findAllPositionLevelNames();

    PositionLevel findPositionLevelByName(String positionLevelName);
}
