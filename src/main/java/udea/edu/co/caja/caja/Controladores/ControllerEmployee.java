package udea.edu.co.caja.caja.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import udea.edu.co.caja.caja.Entidades.Enterprise;
import udea.edu.co.caja.caja.Entidades.Enum_RoleName;
import udea.edu.co.caja.caja.Entidades.Profile;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.caja.caja.Entidades.Employee;
import udea.edu.co.caja.caja.Servicios.ServiciosEmployee;
import udea.edu.co.caja.caja.Servicios.ServiciosProfile;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Employee")
public class ControllerEmployee {
   Profile perfil;
  @Autowired
   ServiciosEmployee serviciosEmployee;
   ServiciosProfile  serviciosProfile;

    public ControllerEmployee (ServiciosEmployee serviciosEmployee, ServiciosProfile serviciosProfile){

        this.serviciosEmployee=serviciosEmployee;
        this.serviciosProfile=serviciosProfile;


    }
   public void refrescarModelo (Model model,@AuthenticationPrincipal OidcUser principal) {
       if (principal!=null){
           model.addAttribute("user", principal.getClaims());
           System.out.println ("Info Usuario:"+principal.getClass())   ;
       }

   }
    @GetMapping(value="/list")
    public String listEmployee(Model model,@AuthenticationPrincipal OidcUser principal){

         refrescarModelo(model,principal);
        // Consultando la lista de Empleados
        List<Employee> listEmployee=serviciosEmployee.listEmployee();
        // Estableciendo en el modelo la lista de empleados, para que el HTML La pueda visualizar
        model.addAttribute("listEmployee",listEmployee);
        return "/Employee/listar";
    }

    @GetMapping (value="/nuevo")
    public String nuevo (@AuthenticationPrincipal OidcUser principal,
                         Model model){
        refrescarModelo(model,principal);
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
    public String guardar(@RequestParam("name") String name, @RequestParam("email")  String email,@RequestParam("role")  String role,
                          @RequestParam("phone") String phone,
                          @AuthenticationPrincipal OidcUser principal,
                          Model model

    )
    {
        refrescarModelo(model,principal);
        serviciosEmployee.guardarEmpleadoPerfil(name,email,phone,role,this.serviciosProfile,this.serviciosEmployee);
        return "redirect:/Employee/list";
    }

    @PostMapping(value="/delete")
    public String eliminar (@ModelAttribute Employee employee){
        // llamo  al Servicio para eliminar el empleado
       serviciosEmployee.eliminar(employee.getId());
        // refrescar la lista de empleados
        return "redirect:/Employee/list";

    }

    @PostMapping(value="/update")
    public String actualizar(@ModelAttribute @Valid Employee employee, BindingResult bindingResult,
                             @AuthenticationPrincipal OidcUser principal,
                             Model model)
    {
        refrescarModelo(model,principal);
        Optional<Employee> employee1=serviciosEmployee.buscar(employee.getId());
        // la busqueda de empleado puede o no traer un resultado;
        if (employee1.isPresent()) { // si el objeto es diferente de null
            employee = employee1.get();//Obtiene una Instancia PErmanente Objeto
            model.addAttribute("employee",employee);
            model.addAttribute("profile",employee.getProfile());
            model.addAttribute("enterprise",employee.getEnterprise());
        }// se obtiene la instancia
        return "Employee/editar";
    }



    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String actualizar(@ModelAttribute("profile") Profile profile,
                             @DateTimeFormat (pattern="yyyy-mm-dd") @ModelAttribute("employee")  Employee employee,
                             @DateTimeFormat (pattern="yyyy-mm-dd") @ModelAttribute("enterprise") Enterprise enterprise, @RequestParam("idProfile") Long idProfile , @RequestParam("idEnterprise") Long idEnterprise , @RequestParam("name") String name, @RequestParam("email")  String email,
                             @RequestParam("role")  String role, @RequestParam("phone") String phone,
                              @AuthenticationPrincipal OidcUser principal,
                              Model model
     )

    {
        refrescarModelo(model,principal);
        employee.setName(name);
        employee.setEmail(email);

        employee.setDateupdateAt(LocalDate.now());
        if (role.equals("Admin")) {
            employee.setRole(Enum_RoleName.Admin);
        }else if (role.equals("Operario")){
            employee.setRole(Enum_RoleName.Operario);
        }
        profile.setId(idProfile);
        profile.setCreatedAt(LocalDate.now());
        profile.setUpdateAt(LocalDate.now());

        // reeestablecer la enterprise
        enterprise.setId(idEnterprise);

        employee.setEnterprise(enterprise);
        employee.setProfile(profile);
        employee.getEnterprise().setId(idEnterprise);
        this.serviciosEmployee.save(employee);
        this.serviciosProfile.guardar(profile);
        return "redirect:/Employee/list";

    }

}
