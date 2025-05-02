package by.cherkas.diplom.department;

import by.cherkas.diplom.department.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final SaveDepartmentService saveDepartmentService;
    private final GetOneDepartmentService getOneDepartmentService;
    private final GetAllDepartmentsService getAllDepartmentsService;
    private final UpdateDepartmentService updateDepartmentService;
    private final DeleteDepartmentService deleteDepartmentService;

    public DepartmentController(
            SaveDepartmentService saveDepartmentService,
            GetOneDepartmentService getOneDepartmentService,
            GetAllDepartmentsService getAllDepartmentsService,
            UpdateDepartmentService updateDepartmentService,
            DeleteDepartmentService deleteDepartmentService) {

        this.saveDepartmentService = saveDepartmentService;
        this.getOneDepartmentService = getOneDepartmentService;
        this.getAllDepartmentsService = getAllDepartmentsService;
        this.updateDepartmentService = updateDepartmentService;
        this.deleteDepartmentService = deleteDepartmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return saveDepartmentService.saveDepartment(department);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable UUID id){
        return getOneDepartmentService.getDepartmentById(id);
    }


    @GetMapping("/get/all")
    public ResponseEntity<List<Department>> getAllWhereCompanyId(@RequestParam(required = false, value = "company") UUID companyId){
        return getAllDepartmentsService.getAllDepartments(companyId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable UUID id, @RequestBody Department department){
        return updateDepartmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID id){
        return deleteDepartmentService.deleteDepartment(id);
    }
}
