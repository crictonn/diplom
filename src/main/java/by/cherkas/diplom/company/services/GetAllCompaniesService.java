package by.cherkas.diplom.company.services;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.company.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCompaniesService {

    private final CompanyRepository companyRepository;

    public GetAllCompaniesService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyRepository.findAll());
    }
}
