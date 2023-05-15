package dev.joaquim.fake_twitter.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotBlank(message = "Author is mandatory")
  @Column(name="author", length=256)
  @Max(256)
  private String author;
  
  @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
  private LocalDateTime localDateTime;

  @NotBlank(message = "Message is mandatory")
  @Max(512)
  @Column(name="message", length=512)
  private String message;
}
