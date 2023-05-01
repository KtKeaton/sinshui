package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.FinishFile;

import java.util.Optional;

@Repository
public interface FinishFileDao extends JpaRepository<FinishFile, Long> {

    Optional<FinishFile> findByFileName(String fileName);

}
