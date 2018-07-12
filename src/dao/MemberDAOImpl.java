package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import domain.MemberBean;
import pool.DBConstant;

public class MemberDAOImpl implements MemberDAO {
	Statement stmt;
	Connection conn;
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAOImpl() {
		try {
			Class.forName(DBConstant.DB_DRIVER);
			conn = DriverManager.getConnection(DBConstant.CONNECTION_URL,
					DBConstant.UERNAME, DBConstant.PASSWORD);
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertName(String name) {
		System.out.println(name);

	}

	@Override
	public List<MemberBean> selectList() {
		List<MemberBean> lst = null;
		try {
			ResultSet rs = stmt.executeQuery("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}

	@Override
	public List<MemberBean> selectSomeList(String member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectOneList(String member) {
		// TODO Auto-generated method stub
		return null;
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
		try {
			String sql = String.format(
					" SELECT MEM_ID ADMINID , " + " TEAM_ID TEAMID ," + " NAME , " + " SSN ," + " ROLL, " + " PASSWORD "
							+ " FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'  AND  PASSWORD  LIKE  '%s' ",
					bean.getMemId(), bean.getPassword());
			ResultSet rs = stmt.executeQuery(sql);
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
