package udea.edu.co.caja.caja.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.edu.co.caja.caja.Entidades.Users;

@Repository
public interface UserRepository extends JpaRepository <Users,Long> {

  Users findByEmail (String email);
  // comienza palabra find seguido del nombre del campo de la entidad con la primera LETRA EN MAYUSCULA
  Users findByName (String name);
  Users findByNickname(String nickname);

}
