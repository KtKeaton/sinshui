package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.CompanyType;

import java.util.Optional;

@Repository
public interface CompanyTypeDao extends JpaRepository<CompanyType, Long> {

    Optional<CompanyType> findByTypeName(String typeName);

}
