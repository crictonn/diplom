package by.cherkas.diplom.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public Optional<User> getUserByUsername(String username);
    public Optional<User> getUserByEmail(String email);

}
