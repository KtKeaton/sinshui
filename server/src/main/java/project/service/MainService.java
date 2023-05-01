package project.service;

import project.data.PositionDetailCreateRequestData;
import project.model.PositionDetail;

import java.util.List;

public interface MainService {

    List<PositionDetail> createPositionDetailWithApi(List<PositionDetailCreateRequestData> positionDetailCreateRequestDataList);

    PositionDetail createPositionDetailWithFile(PositionDetailCreateRequestData positionDetailCreateRequestData);
}
