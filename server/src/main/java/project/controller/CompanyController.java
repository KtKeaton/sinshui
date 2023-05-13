package project.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.data.CompanyCreateRequestData;
import project.service.CompanyService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Company Controller", description = "APIs for Company")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    @Operation(
            summary = "Get All Company Names",
            description = "Get All Company Names.",
            tags = {"company", "get"})
    @GetMapping("/companies")
    public List<String> getAllCompanyNames() {
        return companyService.findAllCompanyNames();
    }

    @Operation(
            summary = "Get All Company Names by Company Type",
            description = "Get All Company Names by Company Type.",
            tags = {"company", "get"})
    @GetMapping("/companies/{companyType}")
    public List<String> getAllCompanyNamesByCompanyType(
            @Schema(description = "soft|design-house|system|chemical|device|semiconductor")
            @PathVariable String companyType) {
        return companyService.findByCompanyType(companyType);
    }

    @Operation(
            summary = "Create Companies",
            description = "Create Companies.",
            tags = {"company", "post"})
    @PostMapping("/companies")
    public void createCompanies(@RequestBody List<CompanyCreateRequestData> companyNames) {
        companyService.createCompanies(companyNames);
    }

}


