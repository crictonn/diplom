package by.cherkas.diplom.validators;

import by.cherkas.diplom.exceptions.ErrorMessages;
import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotValidException;
import by.cherkas.diplom.requisiton.Requisition;

public class RequisitionValidator {
    public static void execute(Requisition requisition){
        if(requisition.getStatus() == null)
            throw new RequisitionNotValidException(ErrorMessages.STATUS_REQUIRED.getMessage());
        if(requisition.getCustomer() == null)
            throw new RequisitionNotValidException(ErrorMessages.USER_REQUIRED.getMessage());
        if(requisition.getEmbassy() == null)
            throw new RequisitionNotValidException(ErrorMessages.EMBASSY_REQUIRED.getMessage());
        if(requisition.getDepartment() == null)
            throw new RequisitionNotValidException(ErrorMessages.DEPARTMENT_REQUIRED.getMessage());
    }
}
