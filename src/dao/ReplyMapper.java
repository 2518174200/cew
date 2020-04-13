package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Reply;

public interface ReplyMapper {

	List<Reply> getReplyList(@Param("id") int id);

	int saveReply(Reply r);

	int deleteReplay(@Param("id") int inviId);

}
