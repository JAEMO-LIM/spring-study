package practice2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice2.Entity.Comment;
import practice2.Service.CommentService;
import practice2.dto.CommentCreateRequest;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Void> saveComment(@PathVariable int postId, @Valid @RequestBody CommentCreateRequest commentCreateRequest) {
        commentService.createComment(postId, commentCreateRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
