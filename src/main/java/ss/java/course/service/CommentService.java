package ss.java.course.service;

import java.util.List;

import ss.java.course.model.Comment;

public interface CommentService {	
	
		Comment findById(Integer comment_id);
		
		void saveComment(Comment comment);
		
		void updateComment(Comment comment);
		
		void deleteCommentById(Integer comment_id);
		
		List<Comment> findAllComments();
}
