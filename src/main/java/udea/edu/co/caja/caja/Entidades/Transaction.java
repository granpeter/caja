package udea.edu.co.caja.caja.Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="concept")
    private String concept;
    @Column(name="amount")
    private float amount;
    @ManyToOne( fetch = FetchType.LAZY)
    private Employee user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;
    @Column(name="createdAt")
    private Date createdAt;
    @Column(name="updateAt")
    private Date updateAt;

    public Transaction(){

    }

    public Transaction(long id, String concept, float amount, Employee user, Enterprise enterprise, Date createdAt, Date updateAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getUser() {
        return user;
    }

}
