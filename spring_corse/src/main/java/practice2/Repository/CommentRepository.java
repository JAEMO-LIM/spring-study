package practice2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice2.Entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostId(int postId);
}
