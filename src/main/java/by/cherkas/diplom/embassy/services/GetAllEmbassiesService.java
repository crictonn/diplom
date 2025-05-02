package by.cherkas.diplom.embassy.services;

import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.embassy.EmbassyRepository;
import by.cherkas.diplom.embassy.countries.Countries;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEmbassiesService {

    private final EmbassyRepository embassyRepository;

    public GetAllEmbassiesService(EmbassyRepository embassyRepository) {
        this.embassyRepository = embassyRepository;
    }

    public ResponseEntity<List<Embassy>> getAllEmbassies(Countries country){
        if(country == null)
            return ResponseEntity.ok(embassyRepository.findAll());
        return ResponseEntity.ok(embassyRepository.findAllByCountry(country));
    }
}
