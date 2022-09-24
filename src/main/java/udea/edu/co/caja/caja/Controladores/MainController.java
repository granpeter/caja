package udea.edu.co.caja.caja.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.co.caja.caja.Entidades.Users;
import udea.edu.co.caja.caja.Servicios.UsersService;

import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("session")
public class MainController {

    @Autowired
    UsersService usersService;
    public MainController (UsersService usersService){
        this.usersService=usersService;

    }
   @GetMapping(value="/")
    public String index (Model model, @AuthenticationPrincipal OidcUser principal,  HttpServletRequest request){
      Users user;
       if (principal!=null) {

           // creacion Usuario y llamo a un Servicio para guardar los datos del usuario que se esta logueando
           // preguntando  si el atributo email se encuentra o no en la base de datos.
           user = usersService.findCreateUsuarios(principal.getClaims());
           //establezco en la session el objeto usuario permanentemente
           model.addAttribute("usuario",user);
           request.getSession().setAttribute("usuario",user);
        }
       return "index";
   }

   @GetMapping(value="/ingresosyegresos/")
    public String ingyegr(){
       return "ingresosyegresos/ingresosyegresos" ;
   }

}
