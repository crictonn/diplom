package by.cherkas.diplom.address.services;

import by.cherkas.diplom.address.AddressRepository;
import by.cherkas.diplom.exceptions.types.address.AddressNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteAddressService {
    private final AddressRepository addressRepository;

    public DeleteAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<Void> deleteAddress(UUID id){
        if(!addressRepository.existsById(id))
            throw new AddressNotFoundException();
        addressRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
