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
		// �� �Խñ��� ���� DB ���� ��ȸ
		int totalArticleCount = dao.selectFreeBoardArticleCount();

		// �� ������ �� ���
		int totalPage = totalArticleCount / COUNT_PER_PAGE;
		if (totalArticleCount % COUNT_PER_PAGE > 0) {
			totalPage++;
		}

		// �ϴ� ���� ������
		int startPage = (page - 1) / 10 * 10 + 1;

		// �ϴ� �� ������
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// limit ������ ���
		int startRow = (page - 1) * COUNT_PER_PAGE;

		// DB ���� ���� �������� ������ �Խñ۵� ��ȸ
		List<FreeBoardArticle> freeboardarticleList = dao.selectFreeBoardArticleList(startRow, COUNT_PER_PAGE);

		// �� �������� ������ ��� ������ ��Ƽ� �۾� �Ϸ�
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
		System.out.println("�׷��ȣ : " + freeboardarticle.getGroupNum());
		System.out.println("�鿩��ȣ : " + freeboardarticle.getSubNum());
		System.out.println("ī��Ʈ��ȣ : " + freeboardarticle.getSubCount());
		
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
		
		// dao.subsubCountUpdate(freeboardarticle);
		
//		boolean result = false;
//		if(dao.checkAnswer(freeboardarticle)>0) {
//			for(int i = 1; i < 10; i++) {
//				freeboardarticle.setSubCount(freeBoardArticlesub.getSubCount()+i);
//				if(dao.checkAnswer(freeboardarticle)==0) {
//					// ���� �� ����.
//					dao.subsubCountUpdate(freeboardarticle);
//					System.out.println(i+"�׷��ȣ : " + freeboardarticle.getGroupNum());
//					System.out.println(i+"�鿩��ȣ : " + freeboardarticle.getSubNum());
//					System.out.println(i+"ī��Ʈ��ȣ : " + freeboardarticle.getSubCount());
//					if(dao.insertAnswerArticle(freeboardarticle)>0) {
//						result = true;
//						break;
//					}else {
//						result = false;
//						break;
//					}
//				}
//			}
//		}else {
//			// ���� �� ����.
//			dao.subCountUpdate(freeboardarticle);
//			if(dao.insertAnswerArticle(freeboardarticle)>0) {
//				return true;
//			}else {
//				return false;
//			}
//		}
//		return result;
	}
	
//	public boolean answerWrite(FreeBoardArticle freeboardarticle, int articleNum) {
//	FreeBoardArticle freeBoardArticlesub = dao.freeboardarticleselect(articleNum);
//	
//	String nickname = dao.selectNickName(freeboardarticle.getId());
//	freeboardarticle.setWriter(nickname);
//	freeboardarticle.setWriteTime(new Date());
//	freeboardarticle.setReadCount(0);
//	freeboardarticle.setGroupNum(freeBoardArticlesub.getGroupNum());
//	freeboardarticle.setSubNum(freeBoardArticlesub.getSubNum()+1);
//	freeboardarticle.setSubCount(freeBoardArticlesub.getSubCount()+1);
//	if(dao.checkAnswer(freeboardarticle)>0) {
//		// ���� �� ����.
//		dao.subCountUpdate(freeboardarticle);
//		if(dao.insertAnswerArticle(freeboardarticle)>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}else {
//		// ���� �� ����.
//		if(dao.insertAnswerArticle(freeboardarticle)>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//}
	

	
//	public boolean answerWrite(FreeBoardArticle freeboardarticle) {
//		String nickname = dao.selectNickName(freeboardarticle.getId());
//		freeboardarticle.setWriter(nickname);
//		freeboardarticle.setWriteTime(new Date());
//		freeboardarticle.setReadCount(0);
//
//		int maxcount = dao.checkAnswer(freeboardarticle);
//		
//		if(maxcount>0) {
//			freeboardarticle.setSubCount(maxcount);
//			// ���� �׷쿡 ���� ī��Ʈ�� ����
//			dao.subsubCountUpdate(freeboardarticle);
//			freeboardarticle.setSubCount(maxcount+1);
//			if(dao.insertAnswerArticle(freeboardarticle)>0) {
//				return true;
//			}else {
//				return false;
//			}
//		}else {
//			// ���� �׷쿡 ���� ī��Ʈ�� ����
//			int ssubcount = freeboardarticle.getSubCount();
//			freeboardarticle.setSubCount(ssubcount-1);
//			dao.subCountUpdate(freeboardarticle);
//			freeboardarticle.setSubCount(ssubcount);
//			if(dao.insertAnswerArticle(freeboardarticle)>0) {
//				return true;
//			}else {
//				return false;
//			}
//		}
//	}
}







