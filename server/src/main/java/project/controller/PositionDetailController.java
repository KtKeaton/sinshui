package project.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.data.base.PageResponseData;
import project.data.PositionDetailCreateRequestData;
import project.data.projection.PositionDetailProjectionData;
import project.service.MainService;
import project.service.PositionDetailService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Position Detail Controller", description = "APIs for Position details")
@Validated
public class PositionDetailController {

    private final MainService mainService;
    private final PositionDetailService positionDetailService;

    @Operation(
            summary = "Create Position Details",
            description = "Create Position Details.",
            tags = {"position detail", "post"})
    @PostMapping("/position_details")
    public void createPositionDetails(@RequestBody List<@Valid PositionDetailCreateRequestData> datas) {
        mainService.createPositionDetailWithApi(datas);
    }

    @Operation(
            summary = "Get All Position Details",
            description = "Get All Position Details.",
            tags = {"position detail", "get"})
    @GetMapping("/position_details")
    public PageResponseData<PositionDetailProjectionData> getAllPositionDetails(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @Schema(description = "all|soft|design-house|system|chemical|device|semiconductor")
            @RequestParam String companyType,
            @Schema(defaultValue = "timestamp:asc", description = "timestamp:asc|desc")
            @RequestParam(defaultValue = "timestamp:asc") String sort
    ) {
        log.info("pageNo: [{}], pageSize: [{}], sort [{}], companyType [{}]", pageNo, pageSize, sort, companyType);
        return positionDetailService.findPositionDetails(pageNo, pageSize, sort, companyType);
    }

}


