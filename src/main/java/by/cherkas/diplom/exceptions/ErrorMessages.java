package by.cherkas.diplom.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {

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
    EMBASSY_NOT_FOUND("Embassy not found");



    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }
}
