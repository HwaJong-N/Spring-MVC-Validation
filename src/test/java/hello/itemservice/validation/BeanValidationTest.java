package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {

    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" "); // 공백
        item.setPrice(0);
        item.setQuantity(10000);

        // violations가 비어있어야 오류가 없는 것
        // 메세지는 hibernate validator에서 기본적으로 제공하는 메세지 ( 원하면 다른 메세지로 바꿀 수 있다 )
        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        for (ConstraintViolation<Item> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage = " + violation.getMessage());
        }
    }
}
