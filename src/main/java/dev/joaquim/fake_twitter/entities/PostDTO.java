package dev.joaquim.fake_twitter.entities;

import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {  
  @NotBlank(message = "Author is mandatory")
  @Size(max=256, message = "Author deve ter no máximo 256 caracteres")
  private String author;

  @NotBlank(message = "Message is mandatory")
  @Size(max=512, message = "Mensage deve ter no máximo 512 caracteres")
  private String message;

  public Post transformToPost() {
    return new Post(0, author, LocalDateTime.now(), message);
  }
}