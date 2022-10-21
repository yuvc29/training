package com.fareye.training.customAnno;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TitleValidator.class)
@Target( ElementType.TYPE )
@Retention(RetentionPolicy.RUNTIME)

public @interface DuplicateTitle {
    String message() default "Title already taken";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
