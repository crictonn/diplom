package by.cherkas.diplom.passport.services;

import by.cherkas.diplom.passport.Passport;
import by.cherkas.diplom.passport.PassportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPassportService {
    private final PassportRepository passportRepository;

    public GetAllPassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public ResponseEntity<List<Passport>> getAllPassport(){
        return ResponseEntity.ok(passportRepository.findAll());
    }
}
