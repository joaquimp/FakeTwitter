package dev.joaquim.fake_twitter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.joaquim.fake_twitter.entities.Post;
import dev.joaquim.fake_twitter.repositories.PostRepository;

@Service
public class PostService {
  @Autowired
  PostRepository repository;

  public List<Post> getAll() {
    try {
      return repository.findAll();
    }catch(Exception e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
    
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
    try {
      Optional<Post> p = repository.findById(id);
      if(p.isPresent()){
        return p.get();
      }
    }catch(Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public Post update(long id, Post post) {
    try {
      Post oldPost = getById(id);
      if (oldPost != null) {
        oldPost.setAuthor(post.getAuthor());
        oldPost.setMessage(post.getMessage());
        repository.save(oldPost);
        return oldPost;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void delete(long id) {
    try {
      repository.deleteById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
