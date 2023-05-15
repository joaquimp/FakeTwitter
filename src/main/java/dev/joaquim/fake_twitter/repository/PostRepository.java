package dev.joaquim.fake_twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaquim.fake_twitter.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByMessageContainingIgnoreCase(String message);
}
