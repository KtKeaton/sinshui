package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.model.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(String companyName);

    @Query(value = """
            SELECT c from Company c
            JOIN c.companyType ct
            WHERE ct.typeName = ?1
            """)
    List<Company> getByCompanyType(String companyType);

}
