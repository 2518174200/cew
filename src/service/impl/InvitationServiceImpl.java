package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.InvitationMapper;
import dao.ReplyMapper;
import pojo.Invitation;
import pojo.Reply;
import service.InvitationService;
import service.ReplyService;

public class InvitationServiceImpl implements InvitationService {
	// ����ִ�ж���
	private SqlSession sqlSession;
	// ����һ�������ظ���Ľӿڶ���
	private ReplyService rs = new ReplyServiceImpl();
	@Override
	public List<Invitation> getInvList() {
		sqlSession = MyBatisUtils.createSqlSession();
		List<Invitation> list = sqlSession.getMapper(InvitationMapper.class).getInvList();
		sqlSession.close();
		return list;
	}
	
	@Override
	public List<Invitation> findyByTitle(String title) {
		sqlSession = MyBatisUtils.createSqlSession();
		List<Invitation> list = sqlSession.getMapper(InvitationMapper.class).findByTitle(title);
		sqlSession.close();
		return list;
	}

	@Override
	public boolean deleteInviById(int inviId) {
		// 1.�Ȳ��һظ������Ƿ��и������ӵĻظ���Ϣ������о�Ҫ��ɾ���ظ��е����ݣ�Ȼ����ɾ�����ӱ������
		sqlSession = MyBatisUtils.createSqlSession();
		// ���ûظ��ӿ��и���id�����������id��ǵ����ӻỰ����
		List<Reply> list = rs.getReplyList(inviId);
		// �жϸ����ӵĻظ��Ƿ�Ϊnull
		if(list.isEmpty()) {
			// ����ɾ�����ӵķ���
			int result = sqlSession.getMapper(InvitationMapper.class).deteleInvi(inviId);
			if(result > 0) {
				sqlSession.commit();
				return true;
			}else {
				sqlSession.rollback();
			}
		}else {
			// ��ȥ����ɾ�������ӵ����лظ����ݣ�Ȼ����ɾ�������ӵ���Ϣ
			boolean relpyResult = rs.deleteReplay(inviId);
			if(relpyResult) {
				int result = sqlSession.getMapper(InvitationMapper.class).deteleInvi(inviId);
				if(result > 0) {
					sqlSession.commit();
					return true;
				}else {
					sqlSession.rollback();
				}
			}else {
				sqlSession.rollback();
			}
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}

}
