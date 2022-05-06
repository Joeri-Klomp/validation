package be.vdab.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;

public class PrijsValidator implements ConstraintValidator<CustomPrijs, BigDecimal> {
    @Override
    public void initialize(CustomPrijs constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    //Bean validation roept isValid op bij validatie van een variabele met @CustomPrijs annotation
    //Returns true als de waarde een correcte waarde bevat
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value == null) {
            //als de waarde null is, moet een extra annotation gebruiker, dus moet true returnen hier
            return true;
        }
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        var aantalCijfersNaKomma = value.scale();
        if (aantalCijfersNaKomma > 2) {
            return false;
        }
        var totaalAantalCijfers = value.precision();
        return totaalAantalCijfers - aantalCijfersNaKomma <= 7;
    }
}
