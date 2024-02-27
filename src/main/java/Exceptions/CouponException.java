package Exceptions;

public class CouponException extends Exception {
    public CouponException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }
}
