package practice2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice2.Entity.Post;
import practice2.Repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
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





}
