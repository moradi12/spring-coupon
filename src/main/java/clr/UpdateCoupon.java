package clr;

import Repository.CouponRepository;
import beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@Order(4)
public class UpdateCoupon implements CommandLineRunner {

    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {

        Optional<Coupon> updateCoupon = couponRepository.findById(2);
        updateCoupon.ifPresent(coupon -> {
// not sure if to change company id and category id
            coupon.setCompanyId(5);
            coupon.setCategoryId(5);
            coupon.setTitle("Coupon Title V2");
            coupon.setDescription("Coupon Description updated"); //
            coupon.setStartDate(LocalDate.now());
            coupon.setEndDate(LocalDate.now().plusDays(30));
            coupon.setAmount(10); // Set amount
            coupon.setPrice(9.99); // Set price
            coupon.setImage("coupon new img.jpg");
            couponRepository.saveAndFlush(coupon);
        });
    }
}
