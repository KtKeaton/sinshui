package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Company extends BaseModel {
    private String companyName;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<PositionDetail> positionDetails;

    public void addPositionDetail(PositionDetail positionDetail) {
        positionDetails.add(positionDetail);
        positionDetail.setCompany(this);
    }

    public static CompanyBuilder builder() {
        return new CustomCompanyBuilder();
    }
    private static class CustomCompanyBuilder extends CompanyBuilder {
        @Override
        public Company build() {
            if (super.positionDetails == null) {
                super.positionDetails = new HashSet<>();
            }
            return super.build();
        }
    }
}

