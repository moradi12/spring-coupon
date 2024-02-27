package beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer companyId;

    @Column(nullable = false)
    private Integer categoryId;

    @Column(nullable = false)
    @Size(min = 2, max = 40)
    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    @Min(1)
    private Integer amount;

    @Min(1)
    private Double price;

    private String image;
}
