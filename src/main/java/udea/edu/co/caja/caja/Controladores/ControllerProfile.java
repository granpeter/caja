package udea.edu.co.caja.caja.Controladores;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/profile")
public class ControllerProfile {

    @GetMapping(value="/list")
    public String listProfile(){
        return "Los Perfiles son Jefe, Operario, Cajero";

    }
    @PostMapping(value = "/save")
    public String guardar (){
        return "Si se Guardo el Profile";
    }

    @PutMapping(value="/actualizar")
    public String actualizo(){
        return "Si se Actualizo";
    }

    @DeleteMapping(value="/borrar")
    public boolean eliminar(boolean elimino) {
         if (elimino==true){
             return true;
          }else{
               return false;
         }
    }

}
