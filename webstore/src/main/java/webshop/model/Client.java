package webshop.model;

import javax.persistence.*;

@Entity(name = "client")
@Table(schema = "test", name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Client() {
    }

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Column
    private String name;

    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
