package me.shinsunyoung.springboot_blogProject.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springboot_blogProject.domain.Article;
import me.shinsunyoung.springboot_blogProject.dto.ArticleListViewResponse;
import me.shinsunyoung.springboot_blogProject.dto.ArticleViewResponse;
import me.shinsunyoung.springboot_blogProject.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles",articles); // articles 키에 블로그 글 리스트 저장

        return "articleList"; //articleList.html 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article",new ArticleViewResponse(article));

        return "article";
    }
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id == null){ // id가 없으면 생성
            model.addAttribute("article",new ArticleViewResponse());
        }else{ //id가 있으면 수정
            Article article = blogService.findById(id);
            model.addAttribute("article",new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
