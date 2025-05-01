package by.cherkas.diplom.department.services;

import by.cherkas.diplom.department.DepartmentRepository;
import by.cherkas.diplom.exceptions.types.department.DepartmentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteDepartmentService {

    private final DepartmentRepository departmentRepository;

    public DeleteDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseEntity<Void> deleteDepartment(UUID id ){

        if(departmentRepository.findById(id).isEmpty())
            throw new DepartmentNotFoundException();

        departmentRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
