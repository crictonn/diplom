package by.cherkas.diplom.customer;

import by.cherkas.diplom.security.jwt.JwtUtils;
import by.cherkas.diplom.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class UserCustomerDTO {
    private User user;
    private String token;

    public UserCustomerDTO(User user) {
        this.user = user;
        this.token = JwtUtils.generateToken(user);
    }
}
