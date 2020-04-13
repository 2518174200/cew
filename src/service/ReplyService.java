package service;

import java.util.List;

import pojo.Reply;

public interface ReplyService {

	List<Reply> getReplyList(int id);

	boolean saveReply(Reply r);

	boolean deleteReplay(int inviId);

}
