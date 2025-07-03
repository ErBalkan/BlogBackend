package erbalkan.blogbackend.core.utilities.messages;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service // Bu sınıf, Spring'in @Service anotasyonu ile işaretlenmiştir.
// Bu, sınıfın bir servis bileşeni olduğunu ve 
// Spring tarafından yönetileceğini belirtir.
public class MessageManager implements MessageService {

    private final MessageSource messageSource;
// MessageManager, MessageService arayüzünü uygular ve
// uygulamanın uluslararasılaştırma (i18n) desteği için mesajları yönetir.
    public MessageManager(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
    // Bu metod, verilen anahtar için mesajı alır ve
    // varsayılan olarak geçerli yerel ayar (locale) ile mesajı döner.
    // Anahtar, properties dosyasında tanımlanmış bir mesajı temsil eder.
    // Örneğin, "user.created" anahtarına sahip bir mesajı alırken,
    // "User created successfully" gibi bir mesaj dönebilir.

    @Override
    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
    // Bu metod, verilen anahtar için mesajı alır ve
    // argümanları kullanarak mesajı biçimlendirir.
    // Bu, dinamik olarak değişen mesajlar için kullanışlıdır.
    // Örneğin, "user.created" anahtarına sahip bir mesajı alırken,
    // "John Doe" gibi bir argüman geçerek mesajı 
    // "User John Doe created successfully" gibi bir biçimde alabiliriz.
}


// LocaleContextHolder.getLocale() → Kullanıcının aktif dilini otomatik çeker. 
// İleride Accept-Language header desteği bile kurabiliriz.