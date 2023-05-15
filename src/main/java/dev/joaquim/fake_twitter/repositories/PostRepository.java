package dev.joaquim.fake_twitter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaquim.fake_twitter.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByMessageContainingIgnoreCase(String message);
}
