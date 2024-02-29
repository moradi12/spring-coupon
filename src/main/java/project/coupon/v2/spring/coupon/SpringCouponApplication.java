package project.coupon.v2.spring.coupon;

import clr.CouponsList;
import clr.InitCreateCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCouponApplication {

    private final InitCreateCoupon initCreateCoupon;
    private final CouponsList couponsList;

    @Autowired
    public SpringCouponApplication(InitCreateCoupon initCreateCoupon, CouponsList couponsList) {
        this.initCreateCoupon = initCreateCoupon;
        this.couponsList = couponsList;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCouponApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeCoupons() {
        return args -> {
            initCreateCoupon.run(args);
            couponsList.run(args);

        };
    }
}
