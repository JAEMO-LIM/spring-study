package practice2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import practice2.Entity.Post;

@Getter @Setter
public class PostCreateRequest {

    @NotBlank(message = "제목은 필수 입력 항목 입니다.")
    private String title;

    @NotBlank(message = "본문은 필수 입력 항목입니다.")
    @Size(min = 10, message = "본문은 최소 10자 이상 입력해야합니다.")
    private String content;

    @NotBlank(message = "작성자는 필수 입력 항목입니다.")
    private String author;

    public Post toEntity() {
        return new Post(this.title, this.content, this.author);
    }
}
