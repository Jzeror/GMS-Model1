package service;

import java.util.List;

import domain.MemberBean;

public interface MemberService {
	public void createMemId(MemberBean mm);

	public List<MemberBean> showAllList();

	public List<MemberBean> showSomeList(String word);

	public boolean showOneList(MemberBean mm);

	public int showCountList();

	public void modifyMember(String member);

	public void removeMember(String member);
	
	public boolean login(MemberBean member);
}
