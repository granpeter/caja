package udea.edu.co.caja.caja.Entidades;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.time.LocalDate;


public class Employee {

  private long id;
  private String email;
  private Profile profile;
  private Enum_RoleName  role;
  private LocalDate dateupdateAt;
  private LocalDate createdAT;

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
}
