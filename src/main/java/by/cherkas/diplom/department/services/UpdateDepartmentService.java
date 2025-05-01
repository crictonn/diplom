package by.cherkas.diplom.department.services;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.department.DepartmentRepository;
import by.cherkas.diplom.exceptions.types.department.DepartmentNotFoundException;
import by.cherkas.diplom.validators.DepartmentValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateDepartmentService {

    private final DepartmentRepository departmentRepository;

    public UpdateDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<Department> updateDepartment(UUID id, Department department){

        if(departmentRepository.findById(id).isEmpty())
            throw new DepartmentNotFoundException();

        DepartmentValidator.execute(department);

        return ResponseEntity.ok(departmentRepository.save(department));
    }
}
