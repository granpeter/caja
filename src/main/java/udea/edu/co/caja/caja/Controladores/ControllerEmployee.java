package udea.edu.co.caja.caja.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import udea.edu.co.caja.caja.Entidades.Profile;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.caja.caja.Entidades.Employee;
import udea.edu.co.caja.caja.Servicios.ServiciosEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/Employee")
public class ControllerEmployee {
   Profile perfil;

   ServiciosEmployee serviciosEmployee;

    ControllerEmployee (){
        this.serviciosEmployee=new ServiciosEmployee();
    }

    @GetMapping(value="/list")
    public ArrayList listEmployee(){
        return serviciosEmployee.listEmployee();
    }

    @GetMapping(value="/list/{id}") //para busquedas por un solo parametro
    public Employee buscarEmployee(@PathVariable int id){
         return serviciosEmployee.buscarEmployee(id);
    }

    @GetMapping(value="/list/nombres") // para busquedas por mas de un parametro
     public String getNombre(@RequestParam String nombre,@RequestParam String apellidos, @RequestParam String cedula ){
         return  cedula +"  "+ nombre + "  "+ apellidos;
    }

    @PostMapping(value="/guardar")
    public ResponseEntity<Employee> guardar(@RequestBody Employee empleado)
    {
        serviciosEmployee.saveEmployee(empleado);
        return new ResponseEntity<Employee>(empleado, HttpStatus.OK);
    }

}
