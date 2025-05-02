package by.cherkas.diplom.requisiton.services;

import by.cherkas.diplom.requisiton.Requisition;
import by.cherkas.diplom.requisiton.RequisitionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllRequisitionsService {
    private final RequisitionRepository requisitionRepository;

    public GetAllRequisitionsService(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    public ResponseEntity<List<Requisition>> getAllRequisitions(){
        return ResponseEntity.ok(requisitionRepository.findAll());
    }
}
