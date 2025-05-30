package by.cherkas.diplom.application.services;

import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotFoundException;
import by.cherkas.diplom.application.Application;
import by.cherkas.diplom.application.ApplicationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneApplicationService {
    private final ApplicationRepository applicationRepository;

    public GetOneApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ResponseEntity<Application> getApplicationById(UUID id){
        Optional<Application> requisition = applicationRepository.findById(id);

        if(requisition.isEmpty())
            throw new RequisitionNotFoundException();
        return ResponseEntity.ok(requisition.get());
    }
}
