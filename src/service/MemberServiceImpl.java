package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {
		return instance;
	}
	private MemberServiceImpl() {}
	@Override
	public void createMemId(MemberBean mm) {
		MemberDAOImpl.getInstance().insertMemId(mm);
	}
	@Override
	public List<MemberBean> showAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MemberBean> showSomeList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean showOneList(MemberBean mm) {
		return MemberDAOImpl.getInstance().selectOneList(mm);
		
	}
	@Override
	public int showCountList() {
		return MemberDAOImpl.getInstance().countAccount();
	}
	@Override
	public void modifyMember(MemberBean member) {
		MemberDAOImpl.getInstance().update(member);
		
	}
	@Override
	public void removeMember(MemberBean member) {
		MemberDAOImpl.getInstance().delete(member);
		
	}
	@Override
	public MemberBean login(MemberBean member) {
	
		
		return MemberDAOImpl.getInstance().login(member);
	}
	@Override
	public void createAge(MemberBean mm) {
			 mm.setAge(String.valueOf(
					119 - Integer.parseInt(mm.getSsn().substring(0,2))));
			 MemberServiceImpl.getInstance().createMemId(mm);
	}
}



/**
	public boolean login(MemberBean member) {
	
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
 * */
 