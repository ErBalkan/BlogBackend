package erbalkan.blogbackend.core.utilities.messages;

public interface MessageService {
    // Bu sınıf i18n (internationalization) için mesajları yönetir.
    // Mesajlar, uygulamanın farklı dillerdeki sürümlerinde kullanılır.
    // Mesajlar, genellikle properties dosyalarında saklanır ve bu sınıf
    // mesajları almak için kullanılır.
    String getMessage(String key); // Belirli bir anahtar için mesajı alır.
    // Anahtar, properties dosyasında tanımlanmış bir mesajı temsil eder.
    String getMessage(String key, Object... args); // Belirli bir anahtar için mesajı alır ve argümanları kullanarak mesajı biçimlendirir.
    // Bu, dinamik olarak değişen mesajlar için kullanışlıdır.
    // yani "user.created" anahtarına sahip bir mesajı alırken,
    // "John Doe" gibi bir argüman geçerek mesajı "User John Doe created successfully" 
    // gibi bir biçimde alabiliriz.
}
