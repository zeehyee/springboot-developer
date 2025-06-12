package me.shinsunyoung.springboot_blogProject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springboot_blogProject.domain.Article;
import me.shinsunyoung.springboot_blogProject.dto.AddArticleRequest;
import me.shinsunyoung.springboot_blogProject.dto.UpdateArticleRequest;
import me.shinsunyoung.springboot_blogProject.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request, String userName){

        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll(){
        return blogRepository.findAll();

    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found " + id));
    }

    public void delete(long id){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found " + id));

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }


    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("not found:" + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());


        return article;
    }

    //게시글을 작성한 유저인지 확인
    private void authorizeArticleAuthor(Article article){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!article.getAuthor().equals(userName)){
            throw new IllegalArgumentException("not authorized");
        }
    }
}

