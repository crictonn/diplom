package by.cherkas.diplom.company.services;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.company.CompanyRepository;
import by.cherkas.diplom.exceptions.types.company.CompanyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateCompanyService {

    private final CompanyRepository companyRepository;

    public UpdateCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<Company> updateCompany(UUID id, Company company){
        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isEmpty())
            throw new CompanyNotFoundException();

        company.setId(id);
        return ResponseEntity.ok(companyRepository.save(company));
    }
}
