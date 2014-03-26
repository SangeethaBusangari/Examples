package ejb;

import java.math.BigDecimal;
import javax.ejb.Stateless;

@Stateless
public class CurrencyConverterBean {
    private BigDecimal USD = new BigDecimal("0.0229137");
    private BigDecimal INR = new BigDecimal("46.589100");

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        if(from.equals(to)) {
            return amount;
        }
        else {
            BigDecimal toRate = findRate(to);
            BigDecimal result = toRate.multiply(amount);
            return result.setScale(2, BigDecimal.ROUND_UP);
        }
    }

    public BigDecimal findRate(String to) {
        BigDecimal returnValue = null;
        if(to.equals("INR")) {
            returnValue = INR;
        }
        if(to.equals("USD")) {
            returnValue = USD;
        }
        return returnValue;
    } 
}
