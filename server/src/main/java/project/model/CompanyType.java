package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company_type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CompanyType extends BaseModel {
    private String typeName;
    private String label;

    @OneToMany(mappedBy = "companyType", fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Company> companies;

    public static CompanyTypeBuilder builder() {
        return new CustomCompanyTypeBuilder();
    }
    private static class CustomCompanyTypeBuilder extends CompanyTypeBuilder {
        @Override
        public CompanyType build() {
            if (super.companies == null) {
                super.companies = new HashSet<>();
            }
            return super.build();
        }
    }
}

