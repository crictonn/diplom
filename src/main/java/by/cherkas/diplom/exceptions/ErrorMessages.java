package by.cherkas.diplom.exceptions;

public enum ErrorMessages {

    USER_NOT_FOUND("User Not Found"),
    USERNAME_REQUIRED("Username is required"),
    EMAIL_REQUIRED("Email is required"),
    INVALID_EMAIL("Invalid email"),
    PASSWORD_REQUIRED("Password is required"),
    INVALID_PASSWORD("Invalid password"),
    CUSTOMER_NOT_FOUND("Customer not found"),
    NEGATIVE_AGE("Age cannot be negative");



    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
