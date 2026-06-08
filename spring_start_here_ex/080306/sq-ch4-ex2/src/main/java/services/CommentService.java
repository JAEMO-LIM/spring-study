package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Component
public class CommentService {
  // 필드에 있던 @Autowired를 제거하고,
  // 값이 변하지 않도록 final 키워드를 추가하는 것이 좋습니다.
  private final CommentRepository commentRepository;
  private final CommentNotificationProxy commentNotificationProxy;

  @Autowired // 이제 생성자에 @Autowired를 붙입니다. (스프링 4.3 이상부터는 생성자가 1개면 이 위치의 @Autowired도 생략 가능!)
  public CommentService(CommentRepository commentRepository,
                        CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
  }

  public void publishComment(Comment comment) {
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }
}
