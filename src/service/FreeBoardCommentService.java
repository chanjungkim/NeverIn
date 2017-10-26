package service;

import java.util.Date;
import java.util.List;

import dao.FreeBoardCommentDao;
import dao.FreeBoardDao;
import vo.FreeBoardArticle;
import vo.FreeBoardComment;

public class FreeBoardCommentService {
	private FreeBoardCommentDao dao = FreeBoardCommentDao.getInstance();
	
	private static FreeBoardCommentService instance = new FreeBoardCommentService();
	public static FreeBoardCommentService getInstance() {
		return instance;
	}
	private FreeBoardCommentService() {
		
	}
	
	public boolean commentwrite(FreeBoardComment freeboardcomment) {
		int groupnum = dao.selectGroupCount(freeboardcomment.getArticlenum());
		freeboardcomment.setGroupnum(groupnum);
		
		if(dao.insertComment(freeboardcomment)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<FreeBoardComment> commentList(int articlenum) {
		List<FreeBoardComment> commentList = dao.commentList(articlenum);
		return commentList;
	}
	
	public boolean deletecomment(int commentnum) {
		if(dao.commentdelete(commentnum)>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean updatecomment(int commentnum, String contents) {
		if(dao.commentupdate(commentnum, contents)>0) {
			return true;
		}else {
			return false;
		}
	}
	
}
