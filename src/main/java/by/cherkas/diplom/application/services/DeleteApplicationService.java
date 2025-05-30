package by.cherkas.diplom.application.services;

import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotFoundException;
import by.cherkas.diplom.application.ApplicationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteApplicationService {
    private final ApplicationRepository applicationRepository;

    public DeleteApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ResponseEntity<Void> deleteRequisition(UUID id){
        if(!applicationRepository.existsById(id))
            throw new RequisitionNotFoundException();
        applicationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
