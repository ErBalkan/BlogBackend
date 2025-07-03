package erbalkan.blogbackend.entities;

import java.time.LocalDateTime;

import erbalkan.blogbackend.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Bu sını bir JPA Entity olarak işaretler
// Entity annotation, sınıfın veritabanında bir tabloya karşılık geldiğini belirtir
@Table(name = "posts")
public class Post implements BaseEntity {

    @Id // Bu alanın birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Bu alanın otomatik olarak artan bir değerle doldurulacağını belirtir
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    // columnDefinition = "TEXT" ifadesi, veritabanında bu sütunun metin olarak tanımlanacağını belirtir
    // Bu, genellikle uzun metinler için kullanılır
    private String content;

    private LocalDateTime createdAt; // Oluşturulma zamanı
    private LocalDateTime updatedAt; // Güncellenme zamanı

    @ManyToOne // Bu ilişki, bir post'un bir kategoriye ait olduğunu belirtir
    // ManyToOne, çok sayıda post'un tek bir kategoriye ait olabileceğini belirtir
    @JoinColumn(name = "category_id") 
    // join column, ilişkilendirilecek sütunun adını belirtir
    // Bu, veritabanında "category_id" adında bir sütun oluşturulacağını belirtir
    // Bu sütun, Post tablosu ile Category tablosu arasındaki ilişkiyi sağlar
    // Yani, her post bir kategoriye ait olacak ve bu kategori bilgisi "category_id" sütununda tutulacaktır 
    private Category category;
}