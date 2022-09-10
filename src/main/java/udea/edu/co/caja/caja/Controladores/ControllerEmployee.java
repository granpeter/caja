package udea.edu.co.caja.caja.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import udea.edu.co.caja.caja.Entidades.Enterprise;
import udea.edu.co.caja.caja.Entidades.Profile;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.caja.caja.Entidades.Employee;
import udea.edu.co.caja.caja.Servicios.ServiciosEmployee;
import udea.edu.co.caja.caja.Servicios.ServiciosProfile;
import udea.edu.co.caja.caja.Entidades.Enum_RoleName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Employee")
public class ControllerEmployee {
   Profile perfil;

   ServiciosEmployee serviciosEmployee;
   ServiciosProfile  serviciosProfile;

    public ControllerEmployee (ServiciosEmployee serviciosEmployee, ServiciosProfile serviciosProfile){

        this.serviciosEmployee=serviciosEmployee;
        this.serviciosProfile=serviciosProfile;
    }

    @GetMapping(value="/list")
    public String listEmployee(Model model){
        // Consultando la lista de Empleados
        List<Employee> listEmployee=serviciosEmployee.listEmployee();
        // Estableciendo en el modelo la lista de empleados, para que el HTML La pueda visualizar
        model.addAttribute("listEmployee",listEmployee);
        return "/Employee/listar";
    }

    @GetMapping (value="/nuevo")
    public String nuevo (){
         return "Employee/nuevo";
    }

    /*
    @GetMapping(value="/list/{id}") //para busquedas por un solo parametro
    public Employee buscarEmployee(@PathVariable int id){
         return serviciosEmployee.buscarEmployee(id);
    }

    @GetMapping(value="/list/nombres") // para busquedas por mas de un parametro
     public String getNombre(@RequestParam String nombre,@RequestParam String apellidos, @RequestParam String cedula ){
         return  cedula +"  "+ nombre + "  "+ apellidos;
    }
*/
    @PostMapping(value="/guardar")
    public String guardar(@RequestParam("name") String name, @RequestParam("email")  String email,@RequestParam("role")  String role, @RequestParam("phone") String phone)
    {
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
        return "redirect:/Employee/listar";
    }

}
