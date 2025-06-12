package me.shinsunyoung.springboot_blogProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shinsunyoung.springboot_blogProject.domain.Article;
import org.springframework.cglib.core.Local;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String author;

    public ArticleViewResponse(Article article){
        this.id = article.getId();
        this.title =article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.author = article.getAuthor();
    }
}
