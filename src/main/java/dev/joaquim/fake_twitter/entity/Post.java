package dev.joaquim.fake_twitter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
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
  
  private String author;
  
  @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
  private LocalDateTime localDateTime;

  private String message;
}
