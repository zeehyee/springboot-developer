package me.shinsunyoung.springboot_blogProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbootBlogProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogProjectApplication.class, args);
	}

}
