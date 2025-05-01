package by.cherkas.diplom.validators;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.exceptions.types.address.AddressNotValidException;
import io.micrometer.common.util.StringUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressValidator {
    public static void execute(Address address){
        if(StringUtils.isEmpty(address.getCity()))
            throw new AddressNotValidException("City cannot be empty");
        if(StringUtils.isEmpty(address.getStreetName()))
            throw new AddressNotValidException("Street name cannot be empty");
        if(StringUtils.isEmpty(address.getHouseNumber()))
            throw new AddressNotValidException("House number cannot be empty");
    }
}
