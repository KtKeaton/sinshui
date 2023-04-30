package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "position_type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PositionType extends BaseModel {
    private String positionTypeName;

    @OneToMany(mappedBy = "positionType", fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<PositionDetail> positionDetails;

    public void addPositionDetail(PositionDetail positionDetail) {
        positionDetails.add(positionDetail);
        positionDetail.setPositionType(this);
    }

    public static PositionTypeBuilder builder() {
        return new CustomPositionTypeBuilder();
    }
    private static class CustomPositionTypeBuilder extends PositionTypeBuilder {
        @Override
        public PositionType build() {
            if (super.positionDetails == null) {
                super.positionDetails = new HashSet<>();
            }
            return super.build();
        }
    }
}
