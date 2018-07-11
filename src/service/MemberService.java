package service;

import java.util.List;

import domain.MemberBean;

public interface MemberService {
	public void createName(String input);

	public List<MemberBean> showAllList();

	public List<MemberBean> showSomeList(String word);

	public MemberBean showOneList(String word);

	public int showCountList();

	public void modifyMember(String member);

	public void removeMember(String member);
	
	public MemberBean login(MemberBean member);
}
