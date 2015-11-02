package ss.java.course.dao.comment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import ss.java.course.dao.AbstractDao;
import ss.java.course.model.Comment;

@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao {

	/*
	 * Find comment by comment_id
	 */
	public Comment findById(Integer comment_id){
	Comment comment = getByKey(comment_id);
	return comment;
	}
	
	/*
	 * Save comment
	 */
	public void saveComment(Comment comment){
		persist(comment);
	}
	
	/*
	 * Delete comment
	 */
	public void deleteCommentById(Integer comment_id){
		Query query = getSession().createSQLQuery("delete from comments where comment_id = :comment_id");
		query.setInteger("comment_id", comment_id);
		query.executeUpdate();
	}
	
	/*
	 * Show all comments
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> findAllComments() {
		Criteria criteria = createEntityCriteria();
		List<Comment> comments = (List<Comment>) criteria.list();
		return comments;
	}

}
