package by.cherkas.diplom.department.services;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.department.DepartmentRepository;
import by.cherkas.diplom.validators.DepartmentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveDepartmentService {

    private final DepartmentRepository departmentRepository;

    public SaveDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<Department> saveDepartment(Department department){

        DepartmentValidator.execute(department);

        return ResponseEntity.status(HttpStatus.CREATED).body(departmentRepository.save(department));
    }
}
