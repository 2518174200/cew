package service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commons.MyBatisUtils;
import dao.ReplyMapper;
import pojo.Reply;
import service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper replyMapper;
	private SqlSession sqlSession;
	@Override
	public List<Reply> getReplyList(int id) {
		sqlSession = MyBatisUtils.createSqlSession();
		replyMapper = sqlSession.getMapper(ReplyMapper.class);
		List<Reply> rlist = replyMapper.getReplyList(id);
		MyBatisUtils.close(sqlSession);
		return rlist;
	}
	@Override
	public boolean saveReply(Reply r) {
		sqlSession = MyBatisUtils.createSqlSession();
		replyMapper = sqlSession.getMapper(ReplyMapper.class);
		int result = replyMapper.saveReply(r);
		if(result > 0) {
			// 提交事务,增、删、改
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	@Override
	public boolean deleteReplay(int inviId) {
		sqlSession = MyBatisUtils.createSqlSession();
		replyMapper = sqlSession.getMapper(ReplyMapper.class);
		int result = replyMapper.deleteReplay(inviId);
		if(result > 0) {
			// 提交事务,增、删、改
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}

}
