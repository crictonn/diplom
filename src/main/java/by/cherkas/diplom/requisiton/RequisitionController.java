package by.cherkas.diplom.requisiton;

import by.cherkas.diplom.requisiton.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/requisition")
public class RequisitionController {
    private final SaveRequisitionService saveRequisitionService;
    private final GetOneRequisitionService getOneRequisitionService;
    private final GetAllRequisitionsService getAllRequisitionsService;
    private final UpdateRequisitionService updateRequisitionService;
    private final DeleteRequisitionService deleteRequisitionService;

    public RequisitionController(
            SaveRequisitionService saveRequisitionService,
            GetOneRequisitionService getOneRequisitionService,
            GetAllRequisitionsService getAllRequisitionsService,
            UpdateRequisitionService updateRequisitionService,
            DeleteRequisitionService deleteRequisitionService) {

        this.saveRequisitionService = saveRequisitionService;
        this.getOneRequisitionService = getOneRequisitionService;
        this.getAllRequisitionsService = getAllRequisitionsService;
        this.updateRequisitionService = updateRequisitionService;
        this.deleteRequisitionService = deleteRequisitionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Requisition> saveRequisition(@RequestBody Requisition requisition){
        return saveRequisitionService.saveRequisition(requisition);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Requisition> getRequisitionById(@PathVariable UUID id){
        return getOneRequisitionService.getRequisitionNyId(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Requisition>> getAllRequisitions(){
        return getAllRequisitionsService.getAllRequisitions();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Requisition> updateRequisition(@PathVariable UUID id, @RequestBody Requisition requisition){
        return updateRequisitionService.updateRequisition(id, requisition);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRequisition(@PathVariable UUID id){
        return deleteRequisitionService.deleteRequisition(id);
    }
}
