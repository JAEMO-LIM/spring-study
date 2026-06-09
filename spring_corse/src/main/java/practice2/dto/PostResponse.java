package practice2.dto;

import lombok.Getter;
import lombok.Setter;
import practice2.Entity.Post;

@Getter
@Setter
public class PostResponse {

//    private int id;
//    private String title;
//    private String content;
//    private String author;
//    private int viewer;
//
//    public PostResponse(Post post) {
//        this.id = post.getId();
//        this.title = post.getTitle();
//        this.content = post.getContent();
//        this.author = post.getAuthor();
//        this.viewer = post.getViewer();
//    }

    private int id;
    private String title;
    private String content;
    private String author;
    private int viewer;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.viewer = post.getViewer();
    }
}
