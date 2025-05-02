package by.cherkas.diplom.department.services;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.department.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetAllDepartmentsService {

    private final DepartmentRepository departmentRepository;

    public GetAllDepartmentsService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<List<Department>> getAllDepartments(UUID id){
        if(id == null)
            return ResponseEntity.ok(departmentRepository.findAll());
        else
            return ResponseEntity.ok(departmentRepository.getAllByCompanyId(id));
    }
}
