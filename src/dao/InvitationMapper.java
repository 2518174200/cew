package dao;
/**
 * �������ӱ�Ľӿ�
 * @author lindy
 * @����ʱ�� 2020��3��31������4:42:01
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Invitation;

public interface InvitationMapper {
	
	List<Invitation> getInvList();
	
	int deleteInvi(@Param("id") int id);

	List<Invitation> findByTitle(@Param("title") String title);

	int deteleInvi(@Param("id") int inviId);
	int getCount();
  List<Invitation>	getPageLists(@Param("currPage")int currPage,@Param("pageSize")int pageSize);
}
