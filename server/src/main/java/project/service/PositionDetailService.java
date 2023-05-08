package project.service;

import project.data.base.PageResponseData;
import project.data.projection.PositionDetailProjectionData;
import project.model.PositionDetail;

public interface PositionDetailService {

    PositionDetail createPositionDetail(PositionDetail positionDetail);

    PageResponseData<PositionDetailProjectionData> findPositionDetails(int pageNo, int pageSize, String sort, String companyType);

}
