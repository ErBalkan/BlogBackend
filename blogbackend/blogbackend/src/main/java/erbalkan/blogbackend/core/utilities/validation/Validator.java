package erbalkan.blogbackend.core.utilities.validation;

// bu arayüz genel bir doğrulama mekanizması sağlar.
// T parametresi, doğrulanacak nesnenin türünü belirtir.
// Bu arayüzü uygulayan sınıflar, validate metodunu implement ederek
// belirli bir nesne türü için doğrulama kurallarını tanımlayabilirler.
public interface Validator<T> {
    void validate(T object);
}

