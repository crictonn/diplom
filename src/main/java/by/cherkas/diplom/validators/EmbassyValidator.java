package by.cherkas.diplom.validators;

import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.exceptions.types.embassy.EmbassyNotValidException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmbassyValidator {
    public static void execute(Embassy embassy){
        if(embassy.getCountry() == null){
            throw new EmbassyNotValidException("Embassy must be connected to a country");
        }
    }
}
