package by.cherkas.diplom.embassy.services;

import by.cherkas.diplom.embassy.EmbassyRepository;
import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.exceptions.types.embassy.EmbassyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateEmbassyService {

    private final EmbassyRepository embassyRepository;

    public UpdateEmbassyService(EmbassyRepository embassyRepository) {
        this.embassyRepository = embassyRepository;
    }

    public ResponseEntity<Embassy> updateEmbassy(UUID id, Embassy embassy){

        Optional<Embassy> optionalEmbassy = embassyRepository.findById(id);

        if(optionalEmbassy.isEmpty())
            throw new EmbassyNotFoundException();

        embassy.setId(id);
        return ResponseEntity.ok(embassyRepository.save(embassy));
    }
}
