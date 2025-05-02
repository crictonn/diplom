package by.cherkas.diplom.embassy.services;

import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.embassy.EmbassyRepository;
import by.cherkas.diplom.exceptions.types.embassy.EmbassyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneEmbassyService {

    private final EmbassyRepository embassyRepository;

    public GetOneEmbassyService(EmbassyRepository embassyRepository) {
        this.embassyRepository = embassyRepository;
    }

    public ResponseEntity<Embassy> getEmbassyById(UUID id){

        Optional<Embassy> embassy = embassyRepository.findById(id);

        if(embassy.isEmpty())
            throw new EmbassyNotFoundException();

        return ResponseEntity.ok(embassy.get());
    }
}
