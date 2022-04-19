package be.vdab.validation.constraints;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//We maken hier een annotation op basis van andere annotations



//Je definieert voor welke source onderdelen je @Prijs kan typen.
//a. METHOD voor een method (Je kan @Prijs typen voor een getter)
//b. FIELD voor de declaratie van een instance variabele (Je kan @Prijs typen voor een instance variabele)
//c. ANNOTATION_TYPE voor de definitie van een andere annotation (Je kan @Prijs gebruiken als basis van nog een andere
// eigen annotation.
@Target({METHOD, FIELD, ANNOTATION_TYPE})
//Je definieert hoe lang Java de annotation behoudt. RUNTIME betekent dat de annotation bij het uitvoeren van het
//programma nog ter beschikking is. Als je SOURCE zou kiezen in plaats van RUNTIME, neemt de compiler de annotation niet
//op in de bytecode.
@Retention(RUNTIME)
//Je typt bij een annotation @Constraint als die annotation een validation annotation is. validatedBy is verplicht te
//vermelden. Je geeft een lege array mee als je een validation annotation maakt op basis van andere validation
//annotations, zoals hier.
@Constraint(validatedBy = {})
//De twee bean validation annotations op basis waarvan wij een annotation aan het maken zijn:
@PositiveOrZero
@Digits(integer = 7, fraction = 2)
public @interface Prijs {
    //Je definieert een annotation parameter. Dit lijkt op de syntax van een method declaratie. String message()
    //betekent dat je aan @Prijs een parameter message kan meegeven. Als je de parameter message niet meegeeft krijgt
    //hij een default waarde. Je geeft die waarde mee met het keyword default. Je bepaalt met de message parameter de
    //key van de foutboodschap die Spring opzoekt in messages.properties.
    String message() default "{be.vdab.Prijs.message}";
    //Een validation annotation moet ook een parameter groups hebben. Het gebruik van die parameter valt buiten de cursus.
    Class<?>[] groups() default{};
    //Een validation annotation moet ook een parameter payload hebben. Het gebruik van die parameter valt buiten de cursus.
    Class<? extends Payload> [] payload() default {};
}
