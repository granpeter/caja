package udea.edu.co.caja.caja.Repositorio;

import org.springframework.stereotype.Repository;
import udea.edu.co.caja.caja.Entidades.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

}
