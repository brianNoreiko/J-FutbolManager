package Repository;

import models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
}
