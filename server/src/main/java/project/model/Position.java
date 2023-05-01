package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "position")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position extends BaseModel {
    private String positionName;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<PositionDetail> positionDetails;

    public static PositionBuilder builder() {
        return new CustomPositionBuilder();
    }
    private static class CustomPositionBuilder extends PositionBuilder {
        @Override
        public Position build() {
            if (super.positionDetails == null) {
                super.positionDetails = new HashSet<>();
            }
            return super.build();
        }
    }
}
