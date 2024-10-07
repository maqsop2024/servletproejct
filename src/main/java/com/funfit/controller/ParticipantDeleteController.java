package com.funfit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.bean.Participants;
import com.funfit.service.ParticipantsService;

/**
 * Servlet implementation class ParticipantDeleteController
 */
@WebServlet("/ParticipantDeleteController")
public class ParticipantDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipantDeleteController() {
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
		int participantId = Integer.parseInt(request.getParameter("participantId"));// convert string to int

		ParticipantsService p = new ParticipantsService();

		// pass the object and get the result
		String result = p.deleteParticipant(participantId);
		request.setAttribute("message", result);

		ParticipantsService ps = new ParticipantsService();
		List<Participants> listOfParticipants = ps.listAllParticipants();
		request.setAttribute("listOfParticipants", listOfParticipants); // request scope
		RequestDispatcher rd = request.getRequestDispatcher("view_participants.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
