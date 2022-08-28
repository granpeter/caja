package udea.edu.co.caja.caja.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class controllerPRofileDesktop {


    public String listProfile(){
        return "Los Perfiles son Jefe, Operario, Cajero";

    }

    public String guardar ()
    {
        return "Si se Guardo";
    }
    public String actualizo(){
        return "Si se Actualizo";
    }

}
