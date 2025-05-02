package by.cherkas.diplom.embassy;

import by.cherkas.diplom.embassy.countries.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmbassyRepository extends JpaRepository<Embassy, UUID> {
    List<Embassy> findAllByCountry(Countries country);
}
