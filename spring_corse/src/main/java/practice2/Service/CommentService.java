package practice2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice2.Entity.Comment;
import practice2.Entity.Post;
import practice2.Repository.CommentRepository;
import practice2.dto.CommentCreateRequest;
import practice2.Repository.PostRepository;
import practice2.dto.CommentResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void createComment(int postId, CommentCreateRequest request) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("Post not found" + postId));

        commentRepository.save(new Comment(request.getContent(), request.getAuthor(), post));
    }

    public List<CommentResponse> getCommentsByPostId(int postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentResponse> responses = comments.stream()
                .map(CommentResponse::new)
                .toList();

        return responses;
    }
}
