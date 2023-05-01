package project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.data.PositionDetailCreateRequestData;
import project.model.PositionDetail;

@Mapper
public interface PositionDetailMapper {
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    PositionDetail requestDataToModel(PositionDetailCreateRequestData positionDetailCreateRequestData);
}
