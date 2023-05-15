package dev.joaquim.fake_twitter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.joaquim.fake_twitter.entity.Post;
import dev.joaquim.fake_twitter.repository.PostRepository;

@Service
public class PostService {
  @Autowired
  PostRepository repository;

  public List<Post> getAll() {
      return repository.findAll();
  }

  public Post createPost(Post post) {
    try {
      return repository.save(post);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Post getById(long id) {
    return repository.getReferenceById(id);
  }
}
