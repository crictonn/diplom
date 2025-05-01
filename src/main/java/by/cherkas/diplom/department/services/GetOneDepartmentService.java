package by.cherkas.diplom.department.services;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.department.DepartmentRepository;
import by.cherkas.diplom.exceptions.types.department.DepartmentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneDepartmentService {

    private final DepartmentRepository departmentRepository;

    public GetOneDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<Department> getDepartmentById(UUID id) {

        Optional<Department> department = departmentRepository.findById(id);

        if(department.isEmpty())
            throw new DepartmentNotFoundException();

        return ResponseEntity.ok(department.get());
    }
}
