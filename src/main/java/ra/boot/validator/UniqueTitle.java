package ra.boot.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HandleUniqueTitle.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  UniqueTitle {
    String message() default "title already exist";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}
