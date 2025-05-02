package by.cherkas.diplom.passport.services;

import by.cherkas.diplom.exceptions.types.passport.PassportNotFoundException;
import by.cherkas.diplom.passport.Passport;
import by.cherkas.diplom.passport.PassportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOnePassportService {
    private final PassportRepository passportRepository;

    public GetOnePassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public ResponseEntity<Passport> getPassportById(String id){
        Optional<Passport> passport = passportRepository.findById(id);

        if(passport.isEmpty())
            throw new PassportNotFoundException();
        return ResponseEntity.ok(passport.get());
    }
}
