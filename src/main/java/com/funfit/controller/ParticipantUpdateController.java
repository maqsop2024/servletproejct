package com.funfit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.bean.Participants;
import com.funfit.dao.ParticipantsDao;
import com.funfit.service.ParticipantsService;

/**
 * Servlet implementation class ParticipantUpdateController
 */
@WebServlet("/ParticipantUpdateController")
public class ParticipantUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipantUpdateController() {
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
		ParticipantsDao particpantsDao = new ParticipantsDao();

		String msg = (String) request.getAttribute("message");

		int participantId = request.getParameter("participantId") == null ? 0
				: Integer.parseInt(request.getParameter("participantId"));

		if (msg != null) {
			request.setAttribute("msg", msg);
		}

		if (participantId == 0) {

			request.getRequestDispatcher("update_participant.jsp").forward(request, response);

		}

		if (participantId > 0) {
			Participants participant = new Participants();
			participant = particpantsDao.findParticipantById(participantId);
			request.setAttribute("participant", participant);
//			System.out.println("participant = " + participant);
		}
		request.getRequestDispatcher("update_participant.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String participantName = request.getParameter("participantName");
		int participantId = request.getParameter("participantId") == null ? 0
				: Integer.parseInt(request.getParameter("participantId"));
		int batchId = request.getParameter("batchId") == null ? 0 : Integer.parseInt(request.getParameter("batchId"));
		String sex = request.getParameter("sex");
		int age = request.getParameter("age") == null ? 0 : Integer.parseInt(request.getParameter("age"));

		if (participantId == 0) {

			ParticipantsService pService = new ParticipantsService();

			String result = pService.addParticipant(batchId, participantName, sex, age);
			request.setAttribute("message", result);
//			System.out.println(
//					"ParticipantUpdate doPost pid = 0" + batchId + " " + participantName + " " + sex + " " + age);
			List<Participants> listOfParticipants = pService.listAllParticipants();
			request.setAttribute("listOfParticipants", listOfParticipants); // request scope
			request.getRequestDispatcher("view_participants.jsp").forward(request, response);
		}

//		System.out.println("participantId ==== " + participantId);

		Participants participant = new Participants();
		participant.setParticipantId(participantId);
		participant.setBatchId(batchId);
		participant.setFullName(participantName);
		participant.setSex(sex);
		participant.setAge(age);
//		System.out.println("participant = " + participant);
		ParticipantsService pService = new ParticipantsService();
		String result = pService.updateParticipant(participant);
		request.setAttribute("message", result);

		List<Participants> listOfParticipants = pService.listAllParticipants();
		request.setAttribute("listOfParticipants", listOfParticipants); // request scope
		request.getRequestDispatcher("view_participants.jsp").forward(request, response);
	}

}
