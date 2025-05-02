package by.cherkas.diplom.embassy;

import by.cherkas.diplom.embassy.countries.Countries;
import by.cherkas.diplom.embassy.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/embassy")
public class EmbassyController {
    private final SaveEmbassyService saveEmbassyService;
    private final GetOneEmbassyService getOneEmbassyService;
    private final GetAllEmbassiesService getAllEmbassiesService;
    private final UpdateEmbassyService updateEmbassyService;
    private final DeleteEmbassyService deleteEmbassyService;

    public EmbassyController(
            SaveEmbassyService saveEmbassyService,
            GetOneEmbassyService getOneEmbassyService,
            GetAllEmbassiesService getAllEmbassiesService,
            UpdateEmbassyService updateEmbassyService,
            DeleteEmbassyService deleteEmbassyService) {

        this.saveEmbassyService = saveEmbassyService;
        this.getOneEmbassyService = getOneEmbassyService;
        this.getAllEmbassiesService = getAllEmbassiesService;
        this.updateEmbassyService = updateEmbassyService;
        this.deleteEmbassyService = deleteEmbassyService;
    }

    @PostMapping("/add")
    public ResponseEntity<Embassy> saveEmbassy(@RequestBody Embassy embassy){
        return saveEmbassyService.saveEmbassy(embassy);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Embassy> getEmbassyById(@PathVariable UUID id){
        return getOneEmbassyService.getEmbassyById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Embassy>> getAllEmbassies(@RequestParam(required = false)Countries country){
        return getAllEmbassiesService.getAllEmbassies(country);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Embassy> updateEmbassy(@PathVariable UUID id, @RequestBody Embassy embassy){
        return updateEmbassyService.updateEmbassy(id, embassy);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmbassy(@PathVariable UUID id){
        return deleteEmbassyService.deleteEmbassy(id);
    }
}
