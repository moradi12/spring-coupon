package Repository;

import beans.Coupon;
import beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Integer, Coupon> {


    void addCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);
    void deleteCoupon(Coupon coupon);

    



}
