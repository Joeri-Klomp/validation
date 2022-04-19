package be.vdab.validation.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    //Tot nu deed Spring de validatie voor je, als jij voor de parameter van een controller method @Valid typte.
    //In deze test doe je de validatie zelf. Je doet dit met een Validator object:
    private Validator validator;
    private Product product;

    @BeforeEach
    void beforeEach() {
        //Je maakt een Validator object met een ValidatorFactory object:
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //maak een validation object:
        validator = factory.getValidator();
        product = new Product();
        product.setAankoopPrijs(BigDecimal.ONE);
        product.setVerkoopprijs(BigDecimal.TEN);
    }

    @Test
    void correctProduct() {
        //Je valideert het product. validate geeft je een verzameling met fouten in het product. De verzameling moet
        //leeg zijn:
        assertThat(validator.validate(product)).isEmpty();
        ;
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1.234", "12345678"})
    void verkeerdeAankoopPrijzen(String prijs) {
        product.setAankoopPrijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-10", "10.234", "12345678"})
    void verkeerdeVerkoopPrijzen(String prijs) {
        product.setVerkoopprijs(new BigDecimal(prijs));
        assertThat(validator.validate(product)).isNotEmpty();
    }

    @Test
    void aankoopPrijs10EnVerkoopPrijs1IsVerkeerd() {
        product.setAankoopPrijs(BigDecimal.TEN);
        product.setVerkoopprijs(BigDecimal.ONE);
        assertThat(validator.validate(product)).isNotEmpty();
    }
}
