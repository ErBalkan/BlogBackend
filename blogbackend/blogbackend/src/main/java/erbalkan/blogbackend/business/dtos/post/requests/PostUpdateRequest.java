package erbalkan.blogbackend.business.dtos.post.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequest {
    // Post güncelleme isteği için gerekli alanları içeren DTO (Data Transfer Object) sınıfı
    // Bu sınıf, post güncelleme işlemleri için gerekli verileri taşır
    private Long id;
    private String title;
    private String content;
    private Long categoryId;
}
