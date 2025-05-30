package by.cherkas.diplom.validators;

import by.cherkas.diplom.exceptions.ErrorMessages;
import by.cherkas.diplom.exceptions.types.requisition.RequisitionNotValidException;
import by.cherkas.diplom.application.Application;

public class RequisitionValidator {
    public static void execute(Application application){
//        if(application.getStatus() == null)
//            throw new RequisitionNotValidException(ErrorMessages.STATUS_REQUIRED.getMessage());
        if(application.getCustomer() == null)
            throw new RequisitionNotValidException(ErrorMessages.USER_REQUIRED.getMessage());
        if(application.getEmbassy() == null)
            throw new RequisitionNotValidException(ErrorMessages.EMBASSY_REQUIRED.getMessage());
        if(application.getDepartment() == null)
            throw new RequisitionNotValidException(ErrorMessages.DEPARTMENT_REQUIRED.getMessage());
    }
}
