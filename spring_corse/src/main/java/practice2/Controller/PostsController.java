package practice2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice2.Entity.Post;
import practice2.Service.PostService;
import practice2.dto.PostCreateRequest;
import practice2.dto.PostResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
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

//    @GetMapping("/posts/{id}")
//    public ResponseEntity<PostResponse> getPostById(@PathVariable int id) {
//        // 서비스에서 조회수 증가와 DTO 포장까지 완료된 결과물을 받음
//        PostResponse response = postService.findById(id);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable int id) {
        log.error("ERROR 레벨 로그 테스트 - ID: {}", id);
        log.warn("WARN 레벨 로그 테스트 - ID: {}", id);
        log.info("INFO 레벨 로그 테스트 - ID: {}", id);
        log.debug("DEBUG 레벨 로그 테스트 - ID: {}", id);
        log.trace("TRACE 레벨 로그 테스트 - ID: {}", id);
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/posts/popular")
    public ResponseEntity<List<PostResponse>> getPopularPosts() {
        postService.findTop3ByViewer();

        return new ResponseEntity<>(postService.findTop3ByViewer(), HttpStatus.OK);
    }
}
