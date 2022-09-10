package udea.edu.co.caja.caja.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="image")
    private String image ;

    @Column(name="phone",nullable = false)
    private String phone;
    @Column(name="createdAt")
    private LocalDate createdAt;
    @Column(name="updateAt")
    private  LocalDate updateAt;

    @OneToOne(mappedBy="profile")
    private Employee employee;

    @Column (name="sexo")
    private String sexo;

    public Profile (){

    }

    public Profile(long id, String image, String phone, LocalDate createdAt, LocalDate updateAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }
}
