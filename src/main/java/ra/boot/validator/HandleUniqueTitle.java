package ra.boot.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.boot.dto.MovieDto;
import ra.boot.service.MovieService;




@Component
public class HandleUniqueTitle implements ConstraintValidator<UniqueTitle, String> {
@Autowired
private MovieService movieService;
 @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext){
   return !movieService.existByTitle(title);
 }
}
