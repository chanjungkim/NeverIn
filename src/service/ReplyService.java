package service;

import java.util.ArrayList;
import java.util.Date;

import dao.ReplyDao;
import vo.Article;
import vo.Member;
import vo.Reply;

public class ReplyService {
    // 서비스가 작업 수행시 DB 명령어 실행 필요할 때 사용할 객체
    private ReplyDao dao = ReplyDao.getInstance();
/////////////////////////////////////////////////////////// 
    // singleton
    private static ReplyService instance;
    public static ReplyService getInstance() {
        if(instance==null)
            instance = new ReplyService();
        return instance;
    }
    private ReplyService() {}
//////////////////////////////////////////////////////////
    public ArrayList<Reply> getReplyList(int articleNum){
    	return dao.select(articleNum);
    }
    public boolean writeReply(Reply reply) {
		reply.setWriteTime(new Date());
		
		// dao 한테 추가작업 시킬 차례
		int insertResult = dao.insert(reply);
		if(insertResult==1) {
			return true;
		}else {
			return false;
		}		
	}
    
    public Reply getReply(String articleNum, String replyNum){
    	return dao.selectReply(articleNum, replyNum);
    }
    
    public int deleteReply(String articleNum, String replyNum){
    	return dao.deleteReply(articleNum, replyNum);
    }
    
    public int updateReply(String articleNum, String replyNum, String contents) {
    	return dao.updateReply(articleNum, replyNum, contents);
    }
}