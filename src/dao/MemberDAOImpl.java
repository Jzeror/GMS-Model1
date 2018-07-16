package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAOImpl() {
	}

	@Override
	public void insertMemId(MemberBean mm) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.UERNAME, DBConstant.PASSWORD).getConnection()
					.createStatement().executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(), mm.getMemId(),
							mm.getName(), mm.getPassword(), mm.getSsn(), mm.getAge()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectList() {
		List<MemberBean> lst = null;
		/*
		 * try { ResultSet rs = stmt.executeQuery(""); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		return lst;
	}

	@Override
	public List<MemberBean> selectSomeList(String member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectOneList(MemberBean mm) {
		boolean flag = true;

		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.UERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement()
					.executeQuery(String.format(MemberQuery.CONFIRM_ID.toString(), mm.getMemId()));
			while (rs.next()) {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == true) {
			MemberServiceImpl.getInstance().createAge(mm);

		}
		return flag;

	}

	@Override
	public int countAccount() {
		int count = 0;
		try {
		ResultSet rs= DatabaseFactory
		.createDatabase(Vendor.ORACLE, DBConstant.UERNAME, DBConstant.PASSWORD)
		.getConnection()
		.createStatement()
		.executeQuery(MemberQuery.COUNT_MEMBER.toString());
		
		while(rs.next()) {
			count = rs.getInt("count");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void update(MemberBean member) {

		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.UERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.UPDATE.toString(), member.getPassword().split("/")[1],member.getPassword().split("/")[0],member.getMemId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(MemberBean member) {

		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.UERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.DELETE.toString(), member.getPassword(),member.getMemId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean mem = null;
			try {
				ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.UERNAME, DBConstant.PASSWORD)
						.getConnection().createStatement()
						.executeQuery(String.format(MemberQuery.LOGIN.toString(), bean.getMemId(), bean.getPassword()));
				if(rs.next()) {
					mem = new MemberBean();
					mem.setAge(rs.getString("AGE"));
				}else {
						mem = new MemberBean();
					mem.setAge("999");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return mem;
	}

}
