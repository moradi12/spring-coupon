package beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20, name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20, name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50, name = "email")
    private String email;

    @NotNull
    @Size(min = 6, max = 20)
    @Column(nullable = false, length = 20, name = "password")
    private String password;
}
