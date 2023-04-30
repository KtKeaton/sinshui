package project.service;

import project.data.PositionDetailCreateRequestData;
import project.model.PositionDetail;

import java.util.List;

public interface MainService {

    List<PositionDetail> createPositionDetail(List<PositionDetailCreateRequestData> positionDetailCreateRequestDataList);
}
