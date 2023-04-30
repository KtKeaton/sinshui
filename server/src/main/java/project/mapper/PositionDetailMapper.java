package project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.data.PositionDetailCreateRequestData;
import project.model.PositionDetail;

@Mapper
public interface PositionDetailMapper {
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "positionType", ignore = true)
    @Mapping(target = "positionLevel", ignore = true)
    PositionDetail requestDataToModel(PositionDetailCreateRequestData positionDetailCreateRequestData);
}
