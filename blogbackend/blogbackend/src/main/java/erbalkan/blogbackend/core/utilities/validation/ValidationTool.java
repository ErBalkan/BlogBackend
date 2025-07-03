package erbalkan.blogbackend.core.utilities.validation;

import erbalkan.blogbackend.core.utilities.results.base.Result;
import erbalkan.blogbackend.core.utilities.results.error.ErrorResult;
import erbalkan.blogbackend.core.utilities.results.success.SuccessResult;

public class ValidationTool {

    // Bu sınıf, verilen bir nesneyi doğrulamak için kullanılan bir araçtır.
    // Validator arayüzünü kullanarak nesneyi doğrular ve sonuçları döner.
    // parametre olarak bir nesne ve bir Validator alır.
    public static <T> Result validate(T object, Validator<T> validator) {
        try {
            validator.validate(object);
            return new SuccessResult(); // Geçtiyse
        } catch (RuntimeException ex) {
            return new ErrorResult(ex.getMessage()); // Fırlatılan hata mesajı
        }
    }
}
