package sit.int204.classicmodelsservice.entities;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    private Integer id;
    private String name;
    private String password;
}
