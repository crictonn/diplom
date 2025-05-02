package by.cherkas.diplom.address;

import by.cherkas.diplom.address.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final SaveAddressService saveAddressService;
    private final GetAddressService getAddressService;
    private final GetAllAddressesService getAllAddressesService;
    private final UpdateAddressService updateAddressService;
    private final DeleteAddressService deleteAddressService;

    public AddressController(
            SaveAddressService saveAddressService,
            GetAddressService getAddressService,
            GetAllAddressesService getAllAddressesService,
            UpdateAddressService updateAddressService,
            DeleteAddressService deleteAddressService) {

        this.saveAddressService = saveAddressService;
        this.getAddressService = getAddressService;
        this.getAllAddressesService = getAllAddressesService;
        this.updateAddressService = updateAddressService;
        this.deleteAddressService = deleteAddressService;
    }

    @PostMapping("/add")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        return saveAddressService.saveAddress(address);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable UUID id){
        return getAddressService.getAddressById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Address>> getAllAddresses(){
        return getAllAddressesService.getAllAddresses();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody Address address){
        return updateAddressService.update(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id){
        return deleteAddressService.deleteAddress(id);
    }
}
