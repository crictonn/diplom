package by.cherkas.diplom.requisiton.services;

import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotFoundException;
import by.cherkas.diplom.requisiton.Requisition;
import by.cherkas.diplom.requisiton.RequisitionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneRequisitionService {
    private final RequisitionRepository requisitionRepository;

    public GetOneRequisitionService(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    public ResponseEntity<Requisition> getRequisitionNyId(UUID id){
        Optional<Requisition> requisition = requisitionRepository.findById(id);

        if(requisition.isEmpty())
            throw new RequisitionNotFoundException();
        return ResponseEntity.ok(requisition.get());
    }
}
