package udea.edu.co.caja.caja.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
   @GetMapping(value="/")
    public String index (){
       return "index";
   }

   @GetMapping(value="/ingresosyegresos/")
    public String ingyegr(){
       return "ingresosyegresos/ingresosyegresos" ;
   }

}
