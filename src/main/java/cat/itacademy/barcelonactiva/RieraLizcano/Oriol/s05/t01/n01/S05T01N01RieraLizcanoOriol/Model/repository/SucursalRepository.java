package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.repository;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n01.S05T01N01RieraLizcanoOriol.Model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
