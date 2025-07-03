package erbalkan.blogbackend.business.dtos.post.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostListResponse {
    // Post listesini içeren DTO (Data Transfer Object) sınıfı
    // Bu sınıf, post listesini istemciye döndürmek için kullanılır
    private Long id;
    private String title;
    private String categoryName;
}
