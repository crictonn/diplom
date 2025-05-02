package by.cherkas.diplom.address.services;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.address.AddressRepository;
import by.cherkas.diplom.exceptions.types.address.AddressNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetAddressService {
    private final AddressRepository addressRepository;

    public GetAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<Address> getAddressById(UUID id){
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty())
            throw new AddressNotFoundException();
        return ResponseEntity.ok(address.get());
    }
}
