package web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    public User(String name, String lastName, int age, String email) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "email", length = 20, nullable = false)
    private String email;
}