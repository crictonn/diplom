package by.cherkas.diplom.company.services;

import by.cherkas.diplom.company.CompanyRepository;
import by.cherkas.diplom.exceptions.types.company.CompanyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCompanyService {
    private final CompanyRepository companyRepository;

    public DeleteCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<Void> deleteCompany(UUID id){
        if(companyRepository.findById(id).isEmpty())
            throw new CompanyNotFoundException();

        companyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
