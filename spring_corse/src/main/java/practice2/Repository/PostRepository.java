package practice2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practice2.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
