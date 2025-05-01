package by.cherkas.diplom.address.services;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.address.AddressRepository;
import by.cherkas.diplom.validators.AddressValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaveAddressService {

    private final AddressRepository addressRepository;

    public SaveAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<Address> saveAddress(Address address){

        AddressValidator.execute(address);
        address.setFullAddress(address.getCity() + ", " + address.getStreetName() + " " + address.getHouseNumber() + ", " + address.getPostIndex());

        return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.save(address));
    }
}
