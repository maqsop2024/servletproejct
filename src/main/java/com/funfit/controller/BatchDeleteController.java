package com.funfit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.bean.Batch;
import com.funfit.service.BatchService;

/**
 * Servlet implementation class BatchDeleteController
 */
@WebServlet("/BatchDeleteController")
public class BatchDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BatchDeleteController() {
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
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		int batchId = Integer.parseInt(request.getParameter("batchId"));// convert string to int

		BatchService bs = new BatchService();

		// pass the object and get the result
		String result = bs.deleteBatch(batchId);
		request.setAttribute("message", result);

		BatchService bsBatchService = new BatchService();
		List<Batch> listOfBatches = bsBatchService.listAllBatches();
		request.setAttribute("listOfBatches", listOfBatches); // request scope
		RequestDispatcher rd = request.getRequestDispatcher("view_batches.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
