package by.cherkas.diplom.requisiton.services;

import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotFoundException;
import by.cherkas.diplom.requisiton.Requisition;
import by.cherkas.diplom.requisiton.RequisitionRepository;
import by.cherkas.diplom.validators.RequisitionValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateRequisitionService {
    private final RequisitionRepository requisitionRepository;

    public UpdateRequisitionService(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    public ResponseEntity<Requisition> updateRequisition(UUID id, Requisition requisition){
        if(!requisitionRepository.existsById(id))
            throw new RequisitionNotFoundException();
        RequisitionValidator.execute(requisition);
        requisition.setId(id);
        return ResponseEntity.ok(requisitionRepository.save(requisition));
    }
}
