package service;

import java.util.Date;
import java.util.List;

import dao.FreeBoardDao;
import vo.FreeBoardArticle;
import vo.FreeBoardArticlePage;

public class FreeBoardService {
	private static final int COUNT_PER_PAGE=10;
	private FreeBoardDao dao = FreeBoardDao.getInstance();

	private static FreeBoardService instance = new FreeBoardService();
	public static FreeBoardService getInstance() {
		return instance;
	}
	private FreeBoardService() {
		
	}

	
	public FreeBoardArticlePage makePage(int page) {
		// 총 게시글의 갯수 DB 에서 조회
		int totalArticleCount = dao.selectFreeBoardArticleCount();

		// 총 페이지 수 계산
		int totalPage = totalArticleCount / COUNT_PER_PAGE;
		if (totalArticleCount % COUNT_PER_PAGE > 0) {
			totalPage++;
		}

		// 하단 시작 페이지
		int startPage = (page - 1) / 10 * 10 + 1;

		// 하단 끝 페이지
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// limit 시작행 계산
		int startRow = (page - 1) * COUNT_PER_PAGE;

		// DB 에서 현재 페이지에 보여질 게시글들 조회
		List<FreeBoardArticle> freeboardarticleList = dao.selectFreeBoardArticleList(startRow, COUNT_PER_PAGE);

		// 한 페이지에 보여질 모든 데이터 담아서 작업 완료
		return new FreeBoardArticlePage
			(freeboardarticleList, startPage, endPage, page, totalPage);
	}
	
	public boolean write(FreeBoardArticle freeboardarticle) {
		String nickname = dao.selectNickName(freeboardarticle.getId());
		int writeCount = dao.selectGroupCount();
		
		freeboardarticle.setWriteTime(new Date());
		freeboardarticle.setReadCount(0);
		if(dao.insertArticle(freeboardarticle, writeCount, nickname)>0)
			return true;
		else
			return false;
		
	}
	
	public FreeBoardArticle read(String loginId, int articleNum) {
		FreeBoardArticle freeboardarticle = dao.freeboardarticleselect(articleNum);
		if(freeboardarticle==null || freeboardarticle.getId().equals(loginId)) {
			return freeboardarticle;
		} else {
			dao.updateReadCount(articleNum);
			freeboardarticle.setReadCount(freeboardarticle.getReadCount()+1);
			return freeboardarticle;
		}
	}
	
	public FreeBoardArticle readNoCount(int articleNum) {
		FreeBoardArticle freeboardarticle = dao.freeboardarticleselect(articleNum);
			return freeboardarticle;
	}
	
	public FreeBoardArticle answerRead(int articleNum) {
		FreeBoardArticle freeboardarticle = dao.freeboardarticleselect(articleNum);
		
		return freeboardarticle;
	}
	
	public boolean delete(int articleNum) {
		if(dao.delete(articleNum)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(FreeBoardArticle freeboardarticle) {
		if(dao.update(freeboardarticle)>0) {
			return true;
		}else {
			return false;
		}
	}
	public String nickname(String loginId) {
		String nickname = dao.selectNickName(loginId);
		return nickname;
	}
	
	public boolean answerWrite(FreeBoardArticle freeboardarticle, int articleNum) {
		FreeBoardArticle freeBoardArticlesub = dao.freeboardarticleselect(articleNum);
		
		String nickname = dao.selectNickName(freeboardarticle.getId());
		freeboardarticle.setWriter(nickname);
		freeboardarticle.setWriteTime(new Date());
		freeboardarticle.setReadCount(0);
		freeboardarticle.setGroupNum(freeBoardArticlesub.getGroupNum());
		freeboardarticle.setSubNum(freeBoardArticlesub.getSubNum()+1);
		freeboardarticle.setSubCount(freeBoardArticlesub.getSubCount()+1);
		
		if(dao.checkAnswer(freeboardarticle)>0) {
			dao.subCountUpdate(freeboardarticle);
			if(dao.insertAnswerArticle(freeboardarticle)>0) {
				return true;
			}else {
				return false;
			}
		} else {
			if(dao.insertAnswerArticle(freeboardarticle)>0) {
				return true;
			}else {
				return false;
			}
		}

	}

}







