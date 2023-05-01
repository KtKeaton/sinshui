package project.service;

import project.model.FinishFile;

import java.util.Optional;

public interface FinishFileService {
    Optional<FinishFile> findFinishFileByFileName(String fileName);

    FinishFile createFinishFile(String fileName);
}
