package by.cherkas.diplom.company.services;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.company.CompanyRepository;
import by.cherkas.diplom.validators.CompanyValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveCompanyService {
    private final CompanyRepository companyRepository;

    public SaveCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<Company> saveCompany(Company company){
        CompanyValidator.execute(company);

        return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(company));
    }
}
