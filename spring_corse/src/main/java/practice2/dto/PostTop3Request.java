package practice2.dto;

import practice2.Entity.Post;

public class PostTop3Request {
    private int id;
    private String title;
    private String content;
    private String author;
    private int viewer = 0;

    public PostTop3Request(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.viewer = post.getViewer();
    }
}
