package by.cherkas.diplom.passport.services;

import by.cherkas.diplom.exceptions.types.passport.PassportNotFoundException;
import by.cherkas.diplom.passport.Passport;
import by.cherkas.diplom.passport.PassportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePassportService {
    private final PassportRepository passportRepository;

    public UpdatePassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public ResponseEntity<Passport> updatePassport(String id, Passport passport){
        Optional<Passport> optionalPassport = passportRepository.findById(id);

        if(optionalPassport.isEmpty())
            throw new PassportNotFoundException();
        passport.setIdentifier(id);
        return ResponseEntity.ok(passportRepository.save(passport));
    }
}
