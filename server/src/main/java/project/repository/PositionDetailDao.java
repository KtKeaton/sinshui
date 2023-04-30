package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.PositionDetail;

@Repository
public interface PositionDetailDao extends JpaRepository<PositionDetail, Long> {
}
