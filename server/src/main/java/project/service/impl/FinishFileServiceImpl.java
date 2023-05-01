package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.FinishFile;
import project.repository.FinishFileDao;
import project.service.FinishFileService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinishFileServiceImpl implements FinishFileService {

    private final FinishFileDao finishFileDao;


    @Override
    @Transactional(readOnly = true)
    public Optional<FinishFile> findFinishFileByFileName(String fileName) {
        return finishFileDao.findByFileName(fileName);
    }

    @Override
    @Transactional
    public FinishFile createFinishFile(String fileName) {
        return finishFileDao.save(FinishFile.builder().fileName(fileName).build());
    }
}
