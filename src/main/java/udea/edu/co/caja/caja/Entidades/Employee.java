package udea.edu.co.caja.caja.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull(message="Debe ingresar un email")
  @Column (name="email",length=30,unique = true,nullable = false)
  private String email;


    @OneToOne
    @JoinColumn(name="idProfile")
    private Profile profile;


    @NotNull(message="El Rol de Empleado solo puede ser Admin o Operario")
  @Column(name="role")
  @Enumerated (value=EnumType.STRING)
  private Enum_RoleName  role;

    @NotNull(message="Debe ingresar un nombre")
  @Column (name="name")
  private String name;

  @Column(name="dateupdateAt")
  private LocalDate dateupdateAt;
  @Column(name="createdAT")
  private LocalDate createdAT;

  @ManyToOne(fetch = FetchType.LAZY)
  private Enterprise enterprise;
 // Constructor VAcio en JPA  JAVA PERSISTENCE API
  public Employee(){

  }
  public Employee(long id, String email,   LocalDate dateupdateAt, LocalDate createdAT) {
    this.id = id;
    this.email = email;
    this.role = role;
    this.dateupdateAt = dateupdateAt;
    this.createdAT = createdAT;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Enum_RoleName getRole() {
    return role;
  }

  public void setRole(Enum_RoleName role) {
    this.role = role;
  }

  public LocalDate getDateupdateAt() {
    return dateupdateAt;
  }

  public void setDateupdateAt(LocalDate dateupdateAt) {
    this.dateupdateAt = dateupdateAt;
  }

  public LocalDate getCreatedAT() {
    return createdAT;
  }

  public void setCreatedAT(LocalDate createdAT) {
    this.createdAT = createdAT;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
