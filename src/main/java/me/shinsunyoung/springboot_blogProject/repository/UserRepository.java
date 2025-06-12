package me.shinsunyoung.springboot_blogProject.repository;

import me.shinsunyoung.springboot_blogProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email); //email로 사용자 정보를 가져옴
}
