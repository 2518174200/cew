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
	// 创建执行对象
	private SqlSession sqlSession;
	// 创建一个操作回复表的接口对象
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
		// 1.先查找回复表中是否有该条帖子的回复信息，如果有就要先删除回复中的数据，然后再删除帖子表的数据
		sqlSession = MyBatisUtils.createSqlSession();
		// 调用回复接口中根据id查找所有域该id相登的帖子会话内容
		List<Reply> list = rs.getReplyList(inviId);
		// 判断该帖子的回复是否为null
		if(list.isEmpty()) {
			// 调用删除帖子的方法
			int result = sqlSession.getMapper(InvitationMapper.class).deteleInvi(inviId);
			if(result > 0) {
				sqlSession.commit();
				return true;
			}else {
				sqlSession.rollback();
			}
		}else {
			// 先去调用删除该帖子的所有回复内容，然后再删除该帖子的信息
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
