package erbalkan.blogbackend.business.dtos.post.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {
    // Post eklendi, Post güncellendi gibi başarılı işlemlerden sonra geri dönüşte kullanılır.
    private Long id;
    private String title;
    private String message;
}
