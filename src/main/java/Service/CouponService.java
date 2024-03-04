package Service;

import Exceptions.CouponNotFoundException;
import Exceptions.ErrMsg;
import Repository.CouponRepository;
import beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }


    public List<Coupon> getAllCoupons() {
        List<Coupon> allCoupons = couponRepository.findAll();
        allCoupons.removeIf(Coupon::isExpired);
        return allCoupons;
    }

    public Coupon getOneCoupon(Integer couponId) throws CouponNotFoundException {
        // Retrieve the coupon by its ID
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg()));    }

    public Coupon getCouponById(Integer couponId) throws CouponNotFoundException {
        return couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponNotFoundException(ErrMsg.COUPON_NOT_FOUND.getMsg()));
    }

    public void addCoupon(Coupon coupon) throws CouponNotFoundException {
        int id = coupon.getId();
        // Check if a coupon with the same ID already exists
        if (couponRepository.findById(id).isPresent()) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_ALREADY_EXISTS.getMsg());
        }
        couponRepository.save(coupon);
    }

    public void updateCoupon(Coupon updateCoupon) throws CouponNotFoundException {
        if (!couponRepository.existsById(updateCoupon.getId())) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
        }
        couponRepository.saveAndFlush(updateCoupon);
    }

    public void deleteCoupon(Integer couponId) throws CouponNotFoundException {
        if (!couponRepository.existsById(couponId)) {
            throw new CouponNotFoundException(ErrMsg.COUPON_ID_NOT_FOUND.getMsg());
        }
        couponRepository.deleteById(couponId);
    }
}



