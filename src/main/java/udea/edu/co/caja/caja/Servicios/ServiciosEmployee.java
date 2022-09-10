package udea.edu.co.caja.caja.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.caja.caja.Entidades.Employee;
import udea.edu.co.caja.caja.Entidades.Profile;
import udea.edu.co.caja.caja.Repositorio.EmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiciosEmployee {

    @Autowired
    EmployeeRepository employeeRepository;
    // Que me haga una inyección por dependencia para el EmployeeRepository

    public ServiciosEmployee(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public List<Employee> listEmployee (){
              return employeeRepository.findAll();

    }

    public Employee save(Employee employee){
         return employeeRepository.save(employee);
    }








}
