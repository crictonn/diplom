package by.cherkas.diplom.passport.services;

import by.cherkas.diplom.passport.Passport;
import by.cherkas.diplom.passport.PassportRepository;
import by.cherkas.diplom.validators.PassportValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SavePassportService {
    private final PassportRepository passportRepository;

    public SavePassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public ResponseEntity<Passport> savePassport(Passport passport){
        PassportValidator.execute(passport);

        return ResponseEntity.status(HttpStatus.CREATED).body(passportRepository.save(passport));
    }
}
