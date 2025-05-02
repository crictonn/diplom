package by.cherkas.diplom.company;

import by.cherkas.diplom.company.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final SaveCompanyService saveCompanyService;
    private final GetOneCompanyService getOneCompanyService;
    private final GetAllCompaniesService getAllCompaniesService;
    private final UpdateCompanyService updateCompanyService;
    private final DeleteCompanyService deleteCompanyService;

    public CompanyController(
            SaveCompanyService saveCompanyService,
            GetOneCompanyService getOneCompanyService,
            GetAllCompaniesService getAllCompaniesService,
            UpdateCompanyService updateCompanyService,
            DeleteCompanyService deleteCompanyService) {

        this.saveCompanyService = saveCompanyService;
        this.getOneCompanyService = getOneCompanyService;
        this.getAllCompaniesService = getAllCompaniesService;
        this.updateCompanyService = updateCompanyService;
        this.deleteCompanyService = deleteCompanyService;
    }

    @PostMapping("/add")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        return saveCompanyService.saveCompany(company);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable UUID id){
        return getOneCompanyService.getCompanyById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return getAllCompaniesService.getAllCompanies();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable UUID id, @RequestBody Company company){
        return updateCompanyService.updateCompany(id, company);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable UUID id){
        return deleteCompanyService.deleteCompany(id);
    }
}
