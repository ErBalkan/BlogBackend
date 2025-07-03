package erbalkan.blogbackend.business.dtos.post.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDeleteRequest {
    // Post silme isteği için gerekli alanları içeren DTO (Data Transfer Object) sınıfı
    // Bu sınıf, post silme işlemleri için gerekli verileri taşır
    private Long id;
}
