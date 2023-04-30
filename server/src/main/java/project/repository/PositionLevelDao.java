package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.PositionLevel;

import java.util.Optional;

@Repository
public interface PositionLevelDao extends JpaRepository<PositionLevel, Long> {
    Optional<PositionLevel> findByPositionLevelName(String positionLevelName);
}
