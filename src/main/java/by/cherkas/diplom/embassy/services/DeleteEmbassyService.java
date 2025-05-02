package by.cherkas.diplom.embassy.services;

import by.cherkas.diplom.embassy.EmbassyRepository;
import by.cherkas.diplom.exceptions.types.embassy.EmbassyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteEmbassyService {
    private final EmbassyRepository embassyRepository;

    public DeleteEmbassyService(EmbassyRepository embassyRepository) {
        this.embassyRepository = embassyRepository;
    }

    public ResponseEntity<Void> deleteEmbassy(UUID id){
        if(embassyRepository.findById(id).isEmpty())
            throw new EmbassyNotFoundException();

        embassyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
