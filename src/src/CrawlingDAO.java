package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import src.CrawlingBean;
import util.DBUtil;

public class CrawlingDAO {
	public static ResourceBundle sql = null;
	private static CrawlingDAO instance;
	static {
		sql = DBUtil.getResourceBundle();
	}

	public static CrawlingDAO getInstance() {
		if (instance == null) {
			instance = new CrawlingDAO();
		}
		return instance;
	}

	// 신규 환전 요청
	public static boolean insertHANA(CrawlingBean Crawling) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.getString("insertHANA"));
			pstmt.setString(1, Crawling.getCrawltime());
			pstmt.setString(2, Crawling.getBuyD());
			pstmt.setString(3, Crawling.getSellD());
			pstmt.setString(4, Crawling.getBuyE());
			pstmt.setString(5, Crawling.getSellE());
			pstmt.setString(6, Crawling.getBuyYu());
			pstmt.setString(7, Crawling.getSellYu());
			pstmt.setString(8, Crawling.getBuyYe());
			pstmt.setString(9, Crawling.getSellYe());
			
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
			return false;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
	public static boolean insertSHINHAN(CrawlingBean Crawling) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.getString("insertSHINHAN"));
			pstmt.setString(1, Crawling.getCrawltime());
			pstmt.setString(2, Crawling.getBuyD());
			pstmt.setString(3, Crawling.getSellD());
			pstmt.setString(4, Crawling.getBuyE());
			pstmt.setString(5, Crawling.getSellE());
			pstmt.setString(6, Crawling.getBuyYu());
			pstmt.setString(7, Crawling.getSellYu());
			pstmt.setString(8, Crawling.getBuyYe());
			pstmt.setString(9, Crawling.getSellYe());
			
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
			return false;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
	public static boolean insertWOORI(CrawlingBean Crawling) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.getString("insertWOORI"));
			pstmt.setString(1, Crawling.getCrawltime());
			pstmt.setString(2, Crawling.getBuyD());
			pstmt.setString(3, Crawling.getSellD());
			pstmt.setString(4, Crawling.getBuyE());
			pstmt.setString(5, Crawling.getSellE());
			pstmt.setString(6, Crawling.getBuyYu());
			pstmt.setString(7, Crawling.getSellYu());
			pstmt.setString(8, Crawling.getBuyYe());
			pstmt.setString(9, Crawling.getSellYe());
			
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
			return false;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
	public static boolean insertKB(CrawlingBean Crawling) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.getString("insertKB"));
			pstmt.setString(1, Crawling.getCrawltime());
			pstmt.setString(2, Crawling.getBuyD());
			pstmt.setString(3, Crawling.getSellD());
			pstmt.setString(4, Crawling.getBuyE());
			pstmt.setString(5, Crawling.getSellE());
			pstmt.setString(6, Crawling.getBuyYu());
			pstmt.setString(7, Crawling.getSellYu());
			pstmt.setString(8, Crawling.getBuyYe());
			pstmt.setString(9, Crawling.getSellYe());
			
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
			return false;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
	
	public static boolean insertNH(CrawlingBean Crawling) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql.getString("insertNH"));
			pstmt.setString(1, Crawling.getCrawltime());
			pstmt.setString(2, Crawling.getBuyD());
			pstmt.setString(3, Crawling.getSellD());
			pstmt.setString(4, Crawling.getBuyE());
			pstmt.setString(5, Crawling.getSellE());
			pstmt.setString(6, Crawling.getBuyYu());
			pstmt.setString(7, Crawling.getSellYu());
			pstmt.setString(8, Crawling.getBuyYe());
			pstmt.setString(9, Crawling.getSellYe());
			
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
			return false;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
}