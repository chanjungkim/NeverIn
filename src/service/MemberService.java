package service;
 
import dao.MemberDao;
import vo.Member;
 
public class MemberService {
    // 서비스가 작업 수행시 DB 명령어 실행 필요할 때 사용할 객체
    private MemberDao dao = MemberDao.getInstance();
/////////////////////////////////////////////////////////// 
    // singleton
    private static MemberService instance;
    public static MemberService getInstance() {
        if(instance==null)
            instance = new MemberService();
        return instance;
    }
    private MemberService() {}
//////////////////////////////////////////////////////////
    public boolean joinMember(Member member) {
        if(dao.insert(member)>0) {
            return true;
        }else {
            return false;
        }
    }
     
    public String login(String id,String pw) {
        String loginId = dao.selectIdUsingIdPw(id,pw);
        return loginId;
    }
    
    public Member getMemberInfo(String id) {
    	Member memberInfo = dao.selectMember(id);
    	return memberInfo;
    }
    
    public int updateMemberInfo(String id, String nickname, String pw) {
    	int result = 0;
    	if(nickname.equals("") || pw.equals("")) {
    		if(!nickname.equals("") && !pw.equals("")){
    			result = dao.updateMember(id, nickname, pw);
    		}else if(pw.equals("")) {
        		result = dao.updateMemberNick(id, nickname);
    		}else if(nickname.equals("")) {
    			result = dao.updateMemberPw(id, pw);
    		}
    	}
    	return result;
    }
    
    public int deleteMemberInfo(String id) {
    	return dao.deleteMember(id);
    }
}