package by.cherkas.diplom.requisiton.services;

import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotFoundException;
import by.cherkas.diplom.requisiton.RequisitionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteRequisitionService {
    private final RequisitionRepository requisitionRepository;

    public DeleteRequisitionService(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    public ResponseEntity<Void> deleteRequisition(UUID id){
        if(!requisitionRepository.existsById(id))
            throw new RequisitionNotFoundException();
        requisitionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
