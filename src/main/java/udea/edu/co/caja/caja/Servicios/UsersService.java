package udea.edu.co.caja.caja.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.caja.caja.Entidades.Users;
import udea.edu.co.caja.caja.Repositorio.UserRepository;

import java.util.Map;

@Service
public class UsersService {
    @Autowired
    UserRepository repositoryUser;

    public UsersService (UserRepository repository){
        this.repositoryUser=repository;
    }

     public Users findCreateUsuarios (Map<String,Object> userData){

         Users usuario=repositoryUser.findByEmail((String)userData.get("email"));
         if (usuario==null){
             //creacion del usuarios
             usuario=new Users();
             usuario.setEmail((String)userData.get("email"));// estableciendo el email del usuario
             usuario.setName((String)userData.get("name"));//estableciendo el nombre del usuario
             usuario.setNickname((String)userData.get("nickname"));//establezco el nombre corto del usuario
             usuario.setPicture((String)userData.get("picture"));

             // Guardo el usuario
             repositoryUser.save(usuario);

         }

         return usuario;
     }


}
