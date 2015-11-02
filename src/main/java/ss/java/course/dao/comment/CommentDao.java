package ss.java.course.dao.comment;

import java.util.List;

import ss.java.course.model.Comment;


public interface CommentDao {
	
	Comment findById(Integer comment_id);
	
	void saveComment(Comment comment);
	
	void deleteCommentById(Integer comment_id);
	
	List<Comment> findAllComments();

}
