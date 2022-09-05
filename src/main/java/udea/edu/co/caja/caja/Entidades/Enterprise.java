package udea.edu.co.caja.caja.Entidades;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name="Enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name="name")
    private String name;
    @Column (name="document")
    private String document;
    @Column (name="phone")
    private String phone;
    @Column (name="address")
    private String address;

    @OneToMany(mappedBy="id", fetch = FetchType.LAZY)
    private List<Employee> users;
    @OneToMany( mappedBy="id",fetch = FetchType.LAZY)
    private List<Transaction>  transactions;
    @Column (name="createdAt")
    private Date createdAt;
    @Column (name="updatedAt")
    private Date updatedAt;

    public Enterprise(){

    }

    public Enterprise(long id, String name, String document, String phone, String address, List<Employee> users, List<Transaction> transactions, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.users = users;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public long getId() {
        return id;
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

    public String getDocument(){
        return document;
    }
}

