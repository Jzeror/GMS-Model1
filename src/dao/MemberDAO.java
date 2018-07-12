package dao;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	public void insertMemId(MemberBean mm);
	public List<MemberBean> selectList();
	public List<MemberBean> selectSomeList(String member);
	public boolean selectOneList(MemberBean mm);
	public int countAccount();
	public void update(MemberBean member);
	public void delete(MemberBean member);
	public MemberBean login(MemberBean bean);
}
