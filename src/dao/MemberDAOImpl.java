package dao;

import java.sql.ResultSet;
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
