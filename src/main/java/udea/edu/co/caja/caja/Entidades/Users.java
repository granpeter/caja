package udea.edu.co.caja.caja.Entidades;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name="Users")
@Scope("session")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String name;

    private String nickname;
    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
