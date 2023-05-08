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
import project.data.CompanyTypeData;
import project.service.CompanyTypeService;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Company Type Controller", description = "APIs for Company Type")
@Validated
public class CompanyTypeController {

    private final CompanyTypeService companyTypeService;

    @Operation(
            summary = "Get All Company Names",
            description = "Get All Company Names.",
            tags = {"company", "get"})
    @GetMapping("/company_types")
    public List<CompanyTypeData> getAllCompanyTypes() {
        return companyTypeService.getAllCompanyTypeDataList();
    }

    @Operation(
            summary = "Create Companies",
            description = "Create Companies.",
            tags = {"company", "post"})
    @PostMapping("/company_types")
    public void createCompanies(@RequestBody List<CompanyTypeData> companyTypeRequestDataList) {
        companyTypeService.createCompanyTypes(companyTypeRequestDataList);
    }

}


