package Service;

import Exceptions.CouponException;
import beans.Coupon;

public interface CouponService {
    void addCoupon(Coupon coupon) throws CouponException;



}
