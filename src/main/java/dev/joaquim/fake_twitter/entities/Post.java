package dev.joaquim.fake_twitter.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
  @Size(max=256, message = "Author deve ter no máximo 256 caracteres")
  @Column(name="author", length=256)
  private String author;
  
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
  private LocalDateTime date;

  @NotBlank(message = "Message is mandatory")
  @Size(max=512, message = "Mensage deve ter no máximo 512 caracteres")
  @Column(name="message", length=512)
  private String message;
}
