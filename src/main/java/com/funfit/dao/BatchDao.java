package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.resource.DbResource;

public class BatchDao {

	public int addBatch(String batchName) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT  INTO batch (BatchName) values (? );");
			pstmt.setString(1, batchName);

			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public List<Batch> listAllBatches() {
		List<Batch> listOfBatches = new ArrayList<Batch>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch;");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Batch b = new Batch();
				b.setBatchId(rs.getInt(1));
				b.setBatchName(rs.getString(2));
				listOfBatches.add(b);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfBatches;
	}

	public int updateBatch(Batch batch) {

		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement pstmt = connection.prepareStatement("update batch set BatchName = ? where BatchId =  ?");
			pstmt.setString(1, batch.getBatchName());
			pstmt.setInt(2, batch.getBatchId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public Batch findBatchById(int id) {

		Batch batch = null;
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Batch WHERE BatchId = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				batch = new Batch();
				batch.setBatchId(rs.getInt(1));
				batch.setBatchName(rs.getString(2));

			}

		} catch (Exception e) {
			System.err.println(e);

		}
		return batch;
	}

	public int deleteBatch(int id) {
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Batch WHERE BatchId = ?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

}
