package by.cherkas.diplom.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ADDRESS_NOT_FOUND("Address not found"),
    USER_NOT_FOUND("User not found"),
    USERNAME_REQUIRED("Username is required"),
    EMAIL_REQUIRED("Email is required"),
    INVALID_EMAIL("Invalid email"),
    PASSWORD_REQUIRED("Password is required"),
    INVALID_PASSWORD("Invalid password"),
    DUPLICATE_USERNAME("Username is already taken"),
    DUPLICATE_EMAIL("Email is already in use"),
    CUSTOMER_NOT_FOUND("Customer not found"),
    NEGATIVE_AGE("Age cannot be negative"),
    DEPARTMENT_NOT_FOUND("Department not found"),
    COMPANY_NOT_FOUND("Company not found"),
    EMBASSY_NOT_FOUND("Embassy not found"),
    PASSPORT_NOT_FOUND("Passport not found"),
    FIRST_NAME_REQUIRED("First name is required"),
    LAST_NAME_REQUIRED("Last name is required"),
    ID_REQUIRED("Identifier is required"),
    SERIAL_REQUIRED("Serial number is required"),
    DOB_REQUIRED("Date of birth is required"),
    EXP_DATE_REQUIRED("Expiration date is required"),
    ISSUED_ADDRESS_REQUIRED("Issued address is required"),
    REQUISITION_NOT_FOUND("Requisition not found"),
    STATUS_REQUIRED("Status is required"),
    USER_REQUIRED("Requisition must have a customer"),
    EMBASSY_REQUIRED("Requisition must be directed to an embassy"),
    DEPARTMENT_REQUIRED("Requisition must be assigned to a department")
    ;



    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }
}
