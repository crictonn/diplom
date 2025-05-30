package by.cherkas.diplom.application.services;

import by.cherkas.diplom.application.Application;
import by.cherkas.diplom.application.ApplicationRepository;
import by.cherkas.diplom.application.status.Statuses;
import by.cherkas.diplom.validators.RequisitionValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveApplicationService {
    private final ApplicationRepository applicationRepository;

    public SaveApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ResponseEntity<Application> saveRequisition(Application application){
        RequisitionValidator.execute(application);
        application.setSubmittedAt(new Date(System.currentTimeMillis()));
        application.setStatus(Statuses.PROCESSING);

        return ResponseEntity.status(HttpStatus.CREATED).body(applicationRepository.save(application));
    }
}
