package erbalkan.blogbackend.business.dtos.post.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateRequest {
    // Post oluşturma isteği için gerekli alanları içeren DTO (Data Transfer Object) sınıfı
    // Bu sınıf, post oluşturma işlemleri için gerekli verileri taşır
    private String title;
    private String content;
    private Long categoryId;
}
