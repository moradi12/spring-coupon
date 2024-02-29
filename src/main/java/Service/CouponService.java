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
        return couponRepository.findAll();
    }

    public Coupon getCouponById(Integer couponId) throws CouponNotFoundException {
        Coupon coupon = couponRepository.findById(couponId).orElse(null);
        if (coupon == null) {
            throw new CouponNotFoundException("Coupon not found");
        }
        return coupon;
    }
    }

