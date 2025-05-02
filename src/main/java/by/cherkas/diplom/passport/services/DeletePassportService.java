package by.cherkas.diplom.passport.services;

import by.cherkas.diplom.exceptions.types.passport.PassportNotFoundException;
import by.cherkas.diplom.passport.PassportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeletePassportService {
    private final PassportRepository passportRepository;

    public DeletePassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public ResponseEntity<Void> deletePassport(String id){
        if(passportRepository.existsById(id)) {
            passportRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        throw new PassportNotFoundException();
    }
}
