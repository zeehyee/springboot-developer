package me.shinsunyoung.springboot_blogProject.repository;

import me.shinsunyoung.springboot_blogProject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {

}
