package project.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.service.PositionService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Position Controller", description = "APIs for Position")
@Validated
public class PositionController {

    private final PositionService positionService;

    @Operation(
            summary = "Get All Positions",
            description = "Get All Positions.",
            tags = {"position", "get"})
    @GetMapping("/positions")
    public List<String> getAllPositionTypeNames() {
        return positionService.findAllPositionTypeNames();
    }

    @Operation(
            summary = "Create Positions",
            description = "Create Positions.",
            tags = {"position", "post"})
    @PostMapping("/positions")
    public void createPositions(@RequestBody List<String> positions) {
        positionService.createPositions(positions);
    }
}


