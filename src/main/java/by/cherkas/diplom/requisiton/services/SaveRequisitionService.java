package by.cherkas.diplom.requisiton.services;

import by.cherkas.diplom.requisiton.Requisition;
import by.cherkas.diplom.requisiton.RequisitionRepository;
import by.cherkas.diplom.requisiton.status.Statuses;
import by.cherkas.diplom.validators.RequisitionValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveRequisitionService {
    private final RequisitionRepository requisitionRepository;

    public SaveRequisitionService(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    public ResponseEntity<Requisition> saveRequisition(Requisition requisition){
        RequisitionValidator.execute(requisition);
        requisition.setAcceptanceDate(new Date(System.currentTimeMillis()));
        requisition.setStatus(Statuses.ACCEPTED);

        return ResponseEntity.status(HttpStatus.CREATED).body(requisitionRepository.save(requisition));
    }
}
