package by.cherkas.diplom.address.services;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.address.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAddressesService {

    private final AddressRepository addressRepository;

    public GetAllAddressesService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity<List<Address>> getAllAddresses(){
        return ResponseEntity.ok(addressRepository.findAll());
    }
}
