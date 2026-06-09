package practice2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateRequest {
    @NotBlank(message = "댓글 내용 필수")
    private String content;
    @NotBlank(message = "작성자 필수")
    private String author;


}
