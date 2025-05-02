package by.cherkas.diplom.company.services;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.company.CompanyRepository;
import by.cherkas.diplom.exceptions.types.company.CompanyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneCompanyService {

    private final CompanyRepository companyRepository;

    public GetOneCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<Company> getCompanyById(UUID id){

        Optional<Company> company = companyRepository.findById(id);

        if(company.isEmpty())
            throw new CompanyNotFoundException();

        return ResponseEntity.ok(company.get());
    }
}
