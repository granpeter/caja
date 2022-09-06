package udea.edu.co.caja.caja.Servicios;

import udea.edu.co.caja.caja.Entidades.Profile;
import org.springframework.stereotype.Service;
import udea.edu.co.caja.caja.Repositorio.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosProfile {
  ProfileRepository profileRepository;

     public ServiciosProfile (ProfileRepository profileRepository){
         this.profileRepository=profileRepository;
     }


    public List<Profile> listarPerfiles(){
        return profileRepository.findAll();

    }

    public Optional<Profile> findProfile (long id){
         return profileRepository.findById(id);
    }

    public Profile guardar(Profile profile){
         return profileRepository.save(profile);

    }

    public void eliminar (Profile profile){
         profileRepository.delete(profile);
    }

}
