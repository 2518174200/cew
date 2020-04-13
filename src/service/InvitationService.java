package service;

import java.util.List;

import pojo.Invitation;

public interface InvitationService {
	List<Invitation> getInvList();
	List<Invitation> findyByTitle(String title);
	boolean deleteInviById(int inviId);
	int getCount();
}
