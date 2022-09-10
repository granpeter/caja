package udea.edu.co.caja.caja.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import udea.edu.co.caja.caja.Entidades.Profile;
import udea.edu.co.caja.caja.Servicios.ServiciosProfile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/profile")
public class ControllerProfile {
ServiciosProfile serviciosProfile;

public ControllerProfile(ServiciosProfile serviciosProfile){
    this.serviciosProfile=serviciosProfile;
}


    @GetMapping(value="/list")
    public List<Profile> listProfile(){
        return serviciosProfile.listarPerfiles();

    }
    @GetMapping(value="/find/{id}")
    public Optional<Profile> findBy (@PathVariable long id){
        return serviciosProfile.findProfile(id);
    }



    @PostMapping(value = "/save")
    public ResponseEntity<Profile> guardar (@RequestBody Profile perfil){
       serviciosProfile.guardar(perfil);
        return new ResponseEntity<Profile>(perfil, HttpStatus.OK);
    }

    @PatchMapping(value="/update")
    public String update(@RequestBody Profile perfil){
        serviciosProfile.guardar(perfil);
    return "redirect:/profile/list";
    }

    @DeleteMapping(value="/delete")
    public String eliminar(@RequestBody Profile profile) {
        serviciosProfile.eliminar(profile);
        return "redirect:/profile/list";
    }

}
