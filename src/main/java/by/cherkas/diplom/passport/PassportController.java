package by.cherkas.diplom.passport;

import by.cherkas.diplom.passport.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final SavePassportService savePassportService;
    private final GetOnePassportService getOnePassportService;
    private final GetAllPassportService getAllPassportService;
    private final UpdatePassportService updatePassportService;
    private final DeletePassportService deletePassportService;

    public PassportController(
            SavePassportService savePassportService,
            GetOnePassportService getOnePassportService,
            GetAllPassportService getAllPassportService,
            UpdatePassportService updatePassportService,
            DeletePassportService deletePassportService) {

        this.savePassportService = savePassportService;
        this.getOnePassportService = getOnePassportService;
        this.getAllPassportService = getAllPassportService;
        this.updatePassportService = updatePassportService;
        this.deletePassportService = deletePassportService;
    }

    @PostMapping("/add")
    public ResponseEntity<Passport> savePassport(@RequestBody Passport passport){
        return savePassportService.savePassport(passport);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Passport> getPassportByIdentifier(@PathVariable String id){
        return getOnePassportService.getPassportById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Passport>> getAllPassports(){
        return getAllPassportService.getAllPassport();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Passport> updatePassport(@PathVariable String id, @RequestBody Passport passport){
        return updatePassportService.updatePassport(id, passport);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePassport(@PathVariable String id){
        return deletePassportService.deletePassport(id);
    }
}
