package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Position;

import java.util.Optional;

@Repository
public interface PositionDao extends JpaRepository<Position, Long> {
    Optional<Position> findByPositionName(String positionName);
}
