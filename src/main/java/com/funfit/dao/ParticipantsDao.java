package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Participants;
import com.funfit.resource.DbResource;

public class ParticipantsDao {

	public int addParticipant(int batchId, String participantName, String sex, int age) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con
					.prepareStatement("INSERT  INTO participants (BatchId, FullName, Sex, Age) values (?, ?, ?, ? );");
			pstmt.setInt(1, batchId);
			pstmt.setString(2, participantName);
			pstmt.setString(3, sex);
			pstmt.setInt(4, age);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public List<Participants> listAllParticipants() {
		List<Participants> listOfParticipants = new ArrayList<Participants>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT ParticipantId, BatchName, FullName, Sex, Age  FROM participants INNER JOIN Batch ON Batch.BatchId = Participants.BatchId ;");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Participants p = new Participants();
				p.setParticipantId(rs.getInt(1));
				p.setBatchName(rs.getString(2));
				p.setFullName(rs.getString(3));
				p.setSex(rs.getString(4));
				p.setAge(rs.getInt(5));
				listOfParticipants.add(p);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfParticipants;
	}

	public int updateParticipant(Participants p) {

		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("UPDATE participants set BatchID = ?, FullName = ?, Sex = ?, Age = ? "
							+ "	where ParticipantId =  ?");
			pstmt.setInt(1, p.getBatchId());
			pstmt.setString(2, p.getFullName());
			pstmt.setString(3, p.getSex());
			pstmt.setInt(4, p.getAge());
			pstmt.setInt(5, p.getParticipantId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public Participants findParticipantById(int id) {

		Participants participant = null;
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT ParticipantId, Participants.BatchId, BatchName, FullName, Sex, Age  " + "FROM participants "
							+ "INNER JOIN Batch ON Batch.BatchId = Participants.BatchId " + "WHERE participantId = ?;");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				participant = new Participants();
				participant.setParticipantId(rs.getInt(1));
				participant.setBatchId(rs.getInt(2));
				participant.setBatchName(rs.getString(3));
				participant.setFullName(rs.getString(4));
				participant.setSex(rs.getString(5));
				participant.setAge(rs.getInt(6));
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		return participant;
	}

	public int deleteParticipant(int id) {
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Participants WHERE ParticipantId = ?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

}
