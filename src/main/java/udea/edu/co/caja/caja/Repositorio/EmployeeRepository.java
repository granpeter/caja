package udea.edu.co.caja.caja.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.edu.co.caja.caja.Entidades.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
