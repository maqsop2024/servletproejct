package com.funfit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;
import com.funfit.service.BatchService;

/**
 * Servlet implementation class BatchUpdateController
 */
@WebServlet("/BatchUpdateController")
public class BatchUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BatchUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BatchDao batchDao = new BatchDao();

		String msg = (String) request.getAttribute("message");

		long batchId = request.getParameter("batchId") == null ? 0 : Integer.parseInt(request.getParameter("batchId"));

		if (msg != null) {
			request.setAttribute("msg", msg);
		}

		if (batchId == 0) {

			request.getRequestDispatcher("update_batch.jsp").forward(request, response);

		}

		if (batchId > 0) {
			Batch batch = new Batch();
			batch = batchDao.findBatchById((int) batchId);
			request.setAttribute("batch", batch);
		}
		request.getRequestDispatcher("update_batch.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String batchName = request.getParameter("batchName");
		long batchId = request.getParameter("batchId") == null ? 0 : Integer.parseInt(request.getParameter("batchId"));
		if (batchId == 0) {

			BatchService bService = new BatchService();
			String result = bService.addBatch(batchName);
			request.setAttribute("message", result);

			List<Batch> listOfBatches = bService.listAllBatches();
			request.setAttribute("listOfBatches", listOfBatches); // request scope
			request.getRequestDispatcher("view_batches.jsp").forward(request, response);
		}

//		System.out.println("batchID ==== " + batchId);

		Batch batch = new Batch((int) batchId, batchName);
//		System.out.println("batch = " + batch);
		BatchService bService = new BatchService();
		String result = bService.updateBatch(batch);
		request.setAttribute("message", result);

		List<Batch> listOfBatches = bService.listAllBatches();
		request.setAttribute("listOfBatches", listOfBatches); // request scope
		request.getRequestDispatcher("view_batches.jsp").forward(request, response);

//		doGet(request, response);

	}

}
