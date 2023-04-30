package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.PositionType;

import java.util.Optional;

@Repository
public interface PositionTypeDao extends JpaRepository<PositionType, Long> {
    Optional<PositionType> findByPositionTypeName(String positionTypeName);
}
