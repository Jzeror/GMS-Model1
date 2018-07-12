package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}

	@Override
	public void insertMemId(MemberBean mm) {
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.UERNAME,
					DBConstant.PASSWORD).getConnection().createStatement().
					executeQuery(String.format(
							" INSERT INTO MEMBER (MEM_ID, NAME, PASSWORD) VALUES ( '%s', '%s', '%s') ",
							mm.getMemId(),mm.getName(),mm.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectList() {
		List<MemberBean> lst = null;
	/*	try {
			ResultSet rs = stmt.executeQuery("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		return lst;
	}

	@Override
	public List<MemberBean> selectSomeList(String member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectOneList(MemberBean mm) {
		boolean flag=true;
		try {
			ResultSet rs=DatabaseFactory.createDatabase(
					Vendor.ORACLE,
					DBConstant.UERNAME,
					DBConstant.PASSWORD).getConnection().createStatement().
					executeQuery(String.format(
							" SELECT MEM_ID ADMINID , " +
					" TEAM_ID TEAMID ," + " NAME , " +
									" SSN ," + " ROLL, " + " PASSWORD "	+
					" FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'   ",
							mm.getMemId()));
			while(rs.next()) {
				flag=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag==true) {MemberServiceImpl.getInstance().createMemId(mm);}
		return flag;
		
	}

	@Override
	public int countAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(MemberBean member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MemberBean member) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean mem=null;

		try {ResultSet rs = DatabaseFactory.createDatabase(
				Vendor.ORACLE,
				DBConstant.UERNAME,
				DBConstant.PASSWORD)
				.getConnection().createStatement().
				executeQuery(String.format(
						" SELECT MEM_ID ADMINID , " +
				" TEAM_ID TEAMID ," + " NAME , " +
								" SSN ," + " ROLL, " + " PASSWORD "	+
				" FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'  AND  PASSWORD  LIKE  '%s' ",
						bean.getMemId(), bean.getPassword()));
			while (rs.next()) {
				mem=new MemberBean();
				mem.setMemId(rs.getString("ADMINID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}

}
