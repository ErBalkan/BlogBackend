package erbalkan.blogbackend.business.dtos.post.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetailResponse {
    // Post detaylarını içeren DTO (Data Transfer Object) sınıfı
    // Bu sınıf, post detaylarını istemciye döndürmek için kullanılır
    private Long id;
    private String title;
    private String content;
    private String categoryName;
    private String createdAt;
    private String updatedAt;
}
