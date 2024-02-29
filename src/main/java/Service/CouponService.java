package Service;

import Exceptions.CouponNotFoundException;
import Repository.CouponRepository;
import beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getAllCoupons() {
        // Get all coupons from the repository
        List<Coupon> allCoupons = couponRepository.findAll();

        // Remove expired coupons from the list
        allCoupons.removeIf(Coupon::isExpired);

        return allCoupons;
    }

    public Coupon getCouponById(Integer couponId) throws CouponNotFoundException {
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found"));
    }
}
