package practice2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice2.Entity.Comment;
import practice2.Service.CommentService;
import practice2.dto.CommentCreateRequest;
import practice2.dto.CommentResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Void> saveComment(@PathVariable int postId, @Valid @RequestBody CommentCreateRequest commentCreateRequest) {
        commentService.createComment(postId, commentCreateRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable int postId) {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }
}
