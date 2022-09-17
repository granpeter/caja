package udea.edu.co.caja.caja.Controladores;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
   @GetMapping(value="/")
    public String index (Model model, @AuthenticationPrincipal OidcUser principal){

       if (principal!=null){
           model.addAttribute("user", principal.getClaims());
           System.out.println ("Info Usuario:"+principal.getClass())   ;
       }

       return "index";
   }

   @GetMapping(value="/ingresosyegresos/")
    public String ingyegr(){
       return "ingresosyegresos/ingresosyegresos" ;
   }

}
