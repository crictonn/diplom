package by.cherkas.diplom.address.services;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.address.AddressRepository;
import by.cherkas.diplom.exceptions.types.address.AddressNotFoundException;
import by.cherkas.diplom.validators.AddressValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateAddressService {
    private final AddressRepository addressRepository;

    public UpdateAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<Address> update(UUID id, Address address){
        if(!addressRepository.existsById(id))
            throw new AddressNotFoundException();

        AddressValidator.execute(address);

        address.setId(id);
        return ResponseEntity.ok(addressRepository.save(address));
    }
}
