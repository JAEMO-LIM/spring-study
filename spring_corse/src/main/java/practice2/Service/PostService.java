package practice2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice2.Entity.Post;
import practice2.Repository.PostRepository;
import practice2.dto.PostResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {
        return  postRepository.findAll();
//        post = post.stream()
//                .viewPlus()
//                .toList();
    }

    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Post update(int id, Post requestPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Post not found" + id));

        post.changePost(requestPost.getTitle(), requestPost.getContent(), requestPost.getAuthor());
        return post;
    }

//    @Transactional
//    public PostResponse findById(int id) {
//        Post post = postRepository.findById(id)
//                .orElseThrow(()-> new IllegalArgumentException("Post not found" + id));
//        post.viewPlus();
//
//        return new PostResponse(post);
//    }

    @Transactional
    public PostResponse findById(int id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Post not found" + id));
        post.viewPlus();

        return new PostResponse(post);
    }

    public List<PostResponse> findTop3ByViewer() {
        List<Post> posts = postRepository.findTop3ByOrderByViewerDesc();
        return posts.stream()
                .map(post -> new PostResponse(post))
                .toList();
    }
}
