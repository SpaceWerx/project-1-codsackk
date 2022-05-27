package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.utilities.ConnectionFactory;



public class ReimbursementDAO {
	
	public int create(Reimbursement reimbursementToBeSubmitted) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "INSERT INTO reimbursements (author, description, type, status, amount)" + 
						"VALUES (?, ?, ?::type, ?::status, ?)" + "RETURNING reimbursements_id;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursementToBeSubmitted.getAuthor());
			ps.setString(2, reimbursementToBeSubmitted.getDescription());
			ps.setObject(3, reimbursementToBeSubmitted.getType().name());
			ps.setObject(4, reimbursementToBeSubmitted.getStatus().name());
			ps.setFloat(5, reimbursementToBeSubmitted.getAmount());
			
			ResultSet rs;
			
			if((rs = ps.executeQuery()) != null) {
				
				rs.next();
				
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("Creating reimbursement has failed");
			e.printStackTrace();
		}
		
	return 0;
	}
	
	public static List<Reimbursement> getAllReimbursements() throws SQLException {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			ResultSet rs = null;
			
			String sql = "SELECT * FROM reimbursements;";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement(
						rs.getInt("reimbursements_id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("description"),
						Type.valueOf(rs.getString("type")),
						Status.valueOf(rs.getString("status")),
						rs.getFloat("amount")
						);
					reimbursements.add(r);
			}
			
			return reimbursements;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with the database!");
			e.printStackTrace();
			return null;
		}
		
		
	}

	public List<Reimbursement> getByStatus(Status status) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM reimbursements WHERE status = ?::status";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,status.toString());
			
			ResultSet rs = ps.executeQuery(sql);
			
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			while(rs.next()) {
				
				reimbursements.add(new Reimbursement(
						rs.getInt("reimbursements_id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("description"),
						Type.valueOf(rs.getString("type")),
						Status.valueOf(rs.getString("status")),
						rs.getFloat("amount")
						
						));
						
			}
			
			return reimbursements;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with obtaining the reimbursements!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Reimbursement getReimbursementById(int id) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM reimbursements WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()) {
				
				return new Reimbursement(
						rs.getInt("reimbursements_id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("description"),
						Type.valueOf(rs.getString("type")),
						Status.valueOf(rs.getString("status")),
						rs.getFloat("amount")
						);
						
			}
			
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with obtaining the reimbursements!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Reimbursement> getReimbursementByUser(int userId) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "SELECT * FROM reimbursements WHERE author = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1,userId);
			
			ResultSet rs = ps.executeQuery(sql);
			
			List<Reimbursement> reimbursements = new ArrayList<>();
			
			while(rs.next()) {
				
				reimbursements.add(new Reimbursement(
						rs.getInt("reimbursements_id"),
						rs.getInt("author"),
						rs.getInt("resolver"),
						rs.getString("description"),
						Type.valueOf(rs.getString("type")),
						Status.valueOf(rs.getString("status")),
						rs.getFloat("amount")
						));
						
			}
			
			return reimbursements;
			
		} catch (SQLException e) {
			
			System.out.println("Something went wrong obtaining your list!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void update(Reimbursement unprocessedReimbursement) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			String sql = "UPDATE reimbursements SET resolver = ?, status = ?::status WHERE reimbursements_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, unprocessedReimbursement.getResolver());
			ps.setObject(2, unprocessedReimbursement.getStatus().name());
			ps.setInt(3, unprocessedReimbursement.getReimbursementsId());
			
			ps.executeUpdate();
			
			System.out.println("Reimbursement Successfully Updated!");
			
		} catch (SQLException e) {
			System.out.println("Update failed!");
			e.printStackTrace();
		}
		
	
	}
}
