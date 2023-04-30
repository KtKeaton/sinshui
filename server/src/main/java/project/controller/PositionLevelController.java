package project.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.PositionLevelService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Position Level Controller", description = "APIs for Position Level")
@Validated
public class PositionLevelController {

    private final PositionLevelService positionLevelService;

    @Operation(
            summary = "Get All Position Level Names",
            description = "Get All Position Level Names.",
            tags = {"position level", "get"})
    @GetMapping("/position_levels")
    public List<String> getAllPositionLevelNames() {
        return positionLevelService.findAllPositionLevelNames();
    }

}


