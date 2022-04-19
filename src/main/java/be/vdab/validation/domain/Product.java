package be.vdab.validation.domain;

import be.vdab.validation.constraints.CustomPrijs;
import be.vdab.validation.constraints.Prijs;
import be.vdab.validation.constraints.VerkoopPrijsAankoopPrijs;

import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
@VerkoopPrijsAankoopPrijs
public class Product {
    @Prijs
    private BigDecimal aankoopPrijs;
    @CustomPrijs
    private BigDecimal verkoopprijs;

    public BigDecimal getAankoopPrijs() {
        return aankoopPrijs;
    }

    public void setAankoopPrijs(BigDecimal aankoopPrijs) {
        this.aankoopPrijs = aankoopPrijs;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }

    public void setVerkoopprijs(BigDecimal verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }
}
