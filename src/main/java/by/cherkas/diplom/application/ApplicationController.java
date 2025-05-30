package by.cherkas.diplom.application;

import by.cherkas.diplom.application.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final SaveApplicationService saveApplicationService;
    private final GetOneApplicationService getOneApplicationService;
    private final GetAllApplicationsService getAllApplicationsService;
    private final UpdateApplicationService updateApplicationService;
    private final DeleteApplicationService deleteApplicationService;

    public ApplicationController(
            SaveApplicationService saveApplicationService,
            GetOneApplicationService getOneApplicationService,
            GetAllApplicationsService getAllApplicationsService,
            UpdateApplicationService updateApplicationService,
            DeleteApplicationService deleteApplicationService) {

        this.saveApplicationService = saveApplicationService;
        this.getOneApplicationService = getOneApplicationService;
        this.getAllApplicationsService = getAllApplicationsService;
        this.updateApplicationService = updateApplicationService;
        this.deleteApplicationService = deleteApplicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Application> saveRequisition(@RequestBody Application application){
        return saveApplicationService.saveRequisition(application);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Application> getRequisitionById(@PathVariable UUID id){
        return getOneApplicationService.getApplicationById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Application>> getAllRequisitions(){
        return getAllApplicationsService.getAllRequisitions();
    }

    @GetMapping("/get/all/customer")
    public ResponseEntity<List<Application>> getAllByCustomer(@RequestHeader String authorization){
        return getAllApplicationsService.getAllByUserID(authorization);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Application> updateRequisition(@PathVariable UUID id, @RequestBody Application application){
        return updateApplicationService.updateRequisition(id, application);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRequisition(@PathVariable UUID id){
        return deleteApplicationService.deleteRequisition(id);
    }
}
