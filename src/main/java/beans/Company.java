package beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, length = 20, name = "email")
    private String email;

    @Column(nullable = false, length = 20, name = "password")
    private String password;

    @OneToMany(mappedBy ="company",cascade = CascadeType.ALL)
    private List<Coupon> coupon = new ArrayList<>();
}
