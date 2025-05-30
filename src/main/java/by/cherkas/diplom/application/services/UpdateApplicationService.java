package by.cherkas.diplom.application.services;

import by.cherkas.diplom.application.Application;
import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotFoundException;
import by.cherkas.diplom.application.ApplicationRepository;
import by.cherkas.diplom.validators.RequisitionValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateApplicationService {
    private final ApplicationRepository applicationRepository;

    public UpdateApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ResponseEntity<Application> updateRequisition(UUID id, Application application){
        if(!applicationRepository.existsById(id))
            throw new RequisitionNotFoundException();
        RequisitionValidator.execute(application);
        application.setId(id);
        return ResponseEntity.ok(applicationRepository.save(application));
    }
}
