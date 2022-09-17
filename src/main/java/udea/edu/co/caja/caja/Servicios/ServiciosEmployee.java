package udea.edu.co.caja.caja.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.caja.caja.Entidades.Employee;
import udea.edu.co.caja.caja.Entidades.Enterprise;
import udea.edu.co.caja.caja.Entidades.Enum_RoleName;
import udea.edu.co.caja.caja.Entidades.Profile;
import udea.edu.co.caja.caja.Repositorio.EmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Employee guardarEmpleadoPerfil(String phone,String name, String email, String role ,ServiciosProfile  serviciosProfile,ServiciosEmployee serviciosEmployee){

        // Crear objeto Profile y guardarlo
        Profile profile= new Profile();
        profile.setPhone(phone);
        profile.setCreatedAt(LocalDate.now());
        profile.setUpdateAt(LocalDate.now());
        // guardo Objeto Profile
        profile=serviciosProfile.guardar(profile);

        // crear el Objeto Employee
        Employee employee=new Employee();
        //Asocio Profile recien creado con autonumerico ya asignado
        employee.setProfile(profile);
        employee.setName(name);
        employee.setEmail(email);
        employee.setCreatedAT(LocalDate.now());
        employee.setDateupdateAt(LocalDate.now());
        Enterprise enterprise=new Enterprise();
        enterprise.setId(1);
        employee.setEnterprise(enterprise);
        if (role.equals("Admin")) {
            employee.setRole(Enum_RoleName.Admin);
        }else if (role.equals("Operario")){
            employee.setRole(Enum_RoleName.Operario);
        }

        // guardar objeto Employee
        serviciosEmployee.save(employee);
        return employee;

    }

    public void eliminar (Long id){
        employeeRepository.deleteById(id);

    }

    public Optional <Employee> buscar (Long id){
        return employeeRepository.findById(id);
    }






}
