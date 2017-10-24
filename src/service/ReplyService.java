package service;

import java.util.ArrayList;

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
}