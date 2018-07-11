package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import domain.MemberBean;


public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAOImpl() {}
	
	
	@Override
	public void insertName(String name) {
		System.out.println(name);
		
	}

	@Override
	public List<MemberBean> selectList() {
		// TODO Auto-generated method stub
		return null;
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
		/* "oracle.jdbc.driver.OracleDriver" 
		 "jdbc:oracle:thin:@localhost:1521:xe" 
		 "jzero" 
		 "fbworud0" */
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jzero","fbworud0");
			String sql = String.format(
					" SELECT MEM_ID ADMINID , " + " TEAM_ID TEAMID ," + " NAME , " + " AGE ," + " ROLL, " + " PASSWORD "
							+ " FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'  AND  PASSWORD  LIKE  '%s' ",
					bean.getMemId(), bean.getPassword());
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				bean.setMemId(rs.getString("ADMINID"));
				bean.setTeamId(rs.getString("TEAMID"));
				bean.setName(rs.getString("NAME"));
				bean.setAge(rs.getString("AGE"));
				bean.setRoll(rs.getString("ROLL"));
				bean.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return bean;
	}

}
