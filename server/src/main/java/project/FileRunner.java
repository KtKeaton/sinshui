package project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import project.data.PositionDetailCreateRequestData;
import project.service.FinishFileService;
import project.service.MainService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileRunner implements ApplicationRunner {

    private final MainService mainService;
    private final FinishFileService finishFileService;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Start reading files");

        String folderPath = "./setting/json";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        Arrays.stream(files).forEach(file -> {
            if (finishFileService.findFinishFileByFileName(file.getName()).isPresent()) {
                log.info("file [{}] skip", file.getName());
            } else {
                log.info("start to process file [{}].....", file.getName());
                ObjectMapper objectMapper = new ObjectMapper();
                List<PositionDetailCreateRequestData> data = null;
                try {
                    data = objectMapper.readValue(file, new TypeReference<>() {
                    });
                } catch (IOException e) {
                    log.error("start to process file [{}], exception :", file.getName(), e);
                }

                if (data != null) {
                    for (PositionDetailCreateRequestData positionDetailCreateRequestData : data) {
                        try {
                            mainService.createPositionDetailWithFile(positionDetailCreateRequestData);
                        } catch (Exception e) {
                            log.error("column error : {}, with data: {}", e.getMessage(), positionDetailCreateRequestData);
                        }
                    }
                }
                log.info("finish processing file [{}].....", file.getName());
                finishFileService.createFinishFile(file.getName());
            }

        });

        log.info("Finish reading files");
    }
}
