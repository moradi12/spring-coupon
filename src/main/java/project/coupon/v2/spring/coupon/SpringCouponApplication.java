package project.coupon.v2.spring.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCouponApplication {

    public static void main(String[] args) {
      ApplicationContext ctx = SpringApplication.run(SpringCouponApplication.class, args);
    }
}
