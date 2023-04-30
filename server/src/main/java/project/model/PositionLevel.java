package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "position_level")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PositionLevel extends BaseModel {
    private String positionLevelName;

    @OneToMany(mappedBy = "positionLevel", fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<PositionDetail> positionDetails;

    public void addPositionDetail(PositionDetail positionDetail) {
        positionDetails.add(positionDetail);
        positionDetail.setPositionLevel(this);
    }

    public static PositionLevelBuilder builder() {
        return new CustomPositionLevelBuilder();
    }
    private static class CustomPositionLevelBuilder extends PositionLevelBuilder {
        @Override
        public PositionLevel build() {
            if (super.positionDetails == null) {
                super.positionDetails = new HashSet<>();
            }
            return super.build();
        }
    }
}
