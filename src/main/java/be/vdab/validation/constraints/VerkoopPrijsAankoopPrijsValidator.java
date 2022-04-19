package be.vdab.validation.constraints;

import be.vdab.validation.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerkoopPrijsAankoopPrijsValidator implements ConstraintValidator<VerkoopPrijsAankoopPrijs, Product> {
    @Override
    public void initialize(VerkoopPrijsAankoopPrijs constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext context) {
        if (product == null) {
            return true;
        }
        if (product.getVerkoopprijs() == null || product.getAankoopPrijs() == null) {
            return false;
        }
        return product.getVerkoopprijs().compareTo(product.getAankoopPrijs())>=0;
    }
}
