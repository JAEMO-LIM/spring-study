package practice2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practice2.Entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findTop3ByOrderByViewerDesc();
}
