package project.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.PositionTypeService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Position Type Controller", description = "APIs for Position Type")
@Validated
public class PositionTypeController {

    private final PositionTypeService positionTypeService;

    @Operation(
            summary = "Get All Position Type Names",
            description = "Get All Position Type Names.",
            tags = {"position type", "get"})
    @GetMapping("/position_types")
    public List<String> getAllPositionTypeNames() {
        return positionTypeService.findAllPositionTypeNames();
    }

}


