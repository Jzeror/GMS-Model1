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
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyMember(String member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeMember(String member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean member) {
		boolean flag = false;
		if(MemberDAOImpl.getInstance().login(member)!=null) {flag=true;}
		return flag;
	}
}



/**
	public boolean login(MemberBean member) {
	
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
 * */
 