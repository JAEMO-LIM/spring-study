package services;

import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publicComment(Comment comment) {
        logger.info("Publishing comment : " + comment);
        return "SUCCES";
    }
}
