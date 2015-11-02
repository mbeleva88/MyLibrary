package ss.java.course.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ss.java.course.dao.comment.CommentDao;
import ss.java.course.model.Comment;


@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao dao;
	
	/*
	 * Find comment by comment_id
	 */
	public Comment findById(Integer comment_id){
		return dao.findById(comment_id);
	}

	/*
	 * Save comment
	 */
	public 	void saveComment(Comment comment){
		dao.saveComment(comment);
	}

	/*
	 * Show all comments
	 */
	public List<Comment> findAllComments(){
		return dao.findAllComments();
	}

	/*
	 * Delete comment
	 */
	public void deleteCommentById(Integer comment_id){
		dao.deleteCommentById(comment_id);
	
	}
	
	/*
	 * Update comment
	 */
	public void updateComment(Comment comment) {
		Comment entity = dao.findById(comment.getComment_id());

		if (entity != null) {
			entity.setComment(comment.getComment());
		}
	}
		
}
