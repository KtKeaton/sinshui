package project.model;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private CompanyType companyType;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<PositionDetail> positionDetails;

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

