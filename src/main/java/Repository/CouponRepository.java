package Repository;

import beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByNameOrID(String name, int id);


    public List<Coupon> PriceLowerThan(Double maxPrice);

}
