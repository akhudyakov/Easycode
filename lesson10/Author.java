package lesson10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zakonN1k on 09.02.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Author {
    String authorName() ;
    String dateOfModification();
}
