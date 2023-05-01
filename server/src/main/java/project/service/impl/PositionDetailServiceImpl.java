package project.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.data.base.PageResponseData;
import project.data.projection.PositionDetailProjectionData;
import project.model.PositionDetail;
import project.repository.PositionDetailDao;
import project.repository.projection.PositionDetailProjectionDao;
import project.service.PositionDetailService;
import project.util.PageUtil;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionDetailServiceImpl implements PositionDetailService {

    private final PositionDetailDao positionDetailDao;
    private final PositionDetailProjectionDao positionDetailProjectionDao;

    @Override
    @Transactional
    public PositionDetail createPositionDetail(PositionDetail positionDetail) {
        return positionDetailDao.save(positionDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponseData<PositionDetailProjectionData> findPositionDetails(int pageNo, int pageSize, String sort) {
        Pageable pageable = PageUtil.getPageable(pageNo, pageSize, sort);
        Page<PositionDetailProjectionData> dataPages = positionDetailProjectionDao.getAllPositionDetails(pageable);
        return PageResponseData.response(dataPages);
    }
}
