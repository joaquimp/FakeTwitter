package dev.joaquim.fake_twitter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.joaquim.fake_twitter.entities.Post;
import dev.joaquim.fake_twitter.entities.PostDTO;
import dev.joaquim.fake_twitter.services.PostService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Post", description = "Fake Twitter Post")
public class PostController {
  @Autowired
  PostService service;

  @ApiResponses({
    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Post.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ValidationError.class), mediaType = "application/json") }),
    @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
  @PostMapping()
  public ResponseEntity<Post> create(@Valid @RequestBody PostDTO postDTO) {
    Post result = service.createPost(postDTO.transformToPost());
    if(result != null) {
      return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    System.out.println("Problema ao tentar salvar o POST");
    return new ResponseEntity<Post>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @GetMapping()
  public List<Post> readAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> readById(@PathVariable(value = "id") long id) {
    Post result = service.getById(id);

    if(result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }

    return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Post> update(@Valid @RequestBody PostDTO postDTO, @PathVariable(value = "id") long id) {
    Post result = service.update(id, postDTO.transformToPost());
    if(result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
    System.out.println("Problema ao tentar atualizar o POST");
    return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
