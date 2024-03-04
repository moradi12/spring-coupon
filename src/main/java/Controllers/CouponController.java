package Controllers;

import Exceptions.CouponNotFoundException;
import Service.CouponService;
import beans.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coupon")
public class CouponController {
    @Autowired
    CouponService couponService;

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestBody Coupon coupon) throws CouponNotFoundException {
        couponService.addCoupon(coupon);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CouponNotFoundException {
        couponService.updateCoupon(id, coupon);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCoupon(@PathVariable int id) throws CouponNotFoundException {
        couponService.deleteCoupon(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coupon getSingleCoupon(@PathVariable int id) throws CouponNotFoundException {
        return couponService.getOneCoupon(id);
    }
}
