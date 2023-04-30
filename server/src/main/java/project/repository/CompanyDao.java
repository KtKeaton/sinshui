package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Company;

import java.util.Optional;

@Repository
public interface  CompanyDao extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(String companyName);

}
