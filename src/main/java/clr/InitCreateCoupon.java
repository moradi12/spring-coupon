package clr;

import Repository.CompaniesRepository;
import Repository.CouponRepository;
import Repository.CustomerRepository;
import beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class InitCreateCoupon implements CommandLineRunner {

    @Autowired
    CompaniesRepository companiesRepository;
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Coupon> coupons = new ArrayList<>();

        Coupon coupon1 = Coupon.builder()
                .companyId(1) // Set company ID
                .categoryId(1) // Set category ID
                .title("Coupon Title") // Set title
                .description("Coupon Description") // Set description
                .startDate(LocalDate.now()) // Set start date
                .endDate(LocalDate.now().plusDays(30))
                .amount(10) // Set amount
                .price(9.99) // Set price
                .image("coupon_image.jpg") // Set image
                .build(); // Build the Coupon instance


        Coupon coupon2 = Coupon.builder()
                .companyId(2)
                .categoryId(2)
                .title("Pc stuff")
                .description("Pc products discount")
                .startDate(LocalDate.now().plusDays(30))
                .amount(4)
                .price(80.99)
                .image("coupon_Pc_image.jpg")
                .build();


        coupons.add(coupon1);
        coupons.add(coupon2);
        couponRepository.saveAll(coupons);
    }


}
