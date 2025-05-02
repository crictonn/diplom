package by.cherkas.diplom.embassy.services;

import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.embassy.EmbassyRepository;
import by.cherkas.diplom.validators.EmbassyValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveEmbassyService {
    private final EmbassyRepository embassyRepository;

    public SaveEmbassyService(EmbassyRepository embassyRepository) {
        this.embassyRepository = embassyRepository;
    }

    public ResponseEntity<Embassy> saveEmbassy(Embassy embassy){
        EmbassyValidator.execute(embassy);

        return ResponseEntity.status(HttpStatus.CREATED).body(embassyRepository.save(embassy));
    }
}
