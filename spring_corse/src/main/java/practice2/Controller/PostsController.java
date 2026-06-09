package practice2.Controller;

import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import practice2.Entity.Post;
import practice2.Service.PostService;
import practice2.dto.PostCreateRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.findAll();
    }

//    @PostMapping("/posts")
//    public Post addPost(@RequestBody Post post) {
//        postService.save(post);
//        return post;
//    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@Valid @RequestBody PostCreateRequest request) {
        Post post = request.toEntity();

        Post savePost = postService.save(post);

        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        postService.update(id, post);
        return post;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deleteById(id);
    }
}
