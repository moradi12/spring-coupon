package clr;

import Repository.CouponRepository;
import beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(3)
public class DeleteCoupon implements CommandLineRunner {

    @Autowired
    CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {

        Optional<Coupon> couponToDelete = couponRepository.findById(1); // Change the ID to the one you want to delete...
        couponToDelete.ifPresent(couponRepository::delete);
    }
}
