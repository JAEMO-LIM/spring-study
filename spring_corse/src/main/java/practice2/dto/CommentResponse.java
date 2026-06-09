package practice2.dto;

import lombok.Getter;
import practice2.Entity.Comment;

@Getter
public class CommentResponse {
    private int id;
    private String content;
    private String author;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getComment();
        this.author = comment.getAuthor();
    }
}