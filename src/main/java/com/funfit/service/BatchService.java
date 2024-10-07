package com.funfit.service;

import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;

public class BatchService {
	BatchDao batchDao = new BatchDao();

	public String addBatch(String batchName) {
		batchDao.addBatch(batchName);
		return "Batch added";
	}

	public List<Batch> listAllBatches() {
		return batchDao.listAllBatches();
	}

	public String updateBatch(Batch batch) {
		if (batchDao.updateBatch(batch) > 0) {
			return "Batch name updated successfully";
		} else {
			return "Batch not present";
		}

	}

	public String deleteBatch(int batchId) {
		if (batchDao.deleteBatch(batchId) > 0) {
			return "Batch " + batchId + " deleted.";
		} else {
			return "Batch  " + batchId + "  not present";
		}

	}

}
