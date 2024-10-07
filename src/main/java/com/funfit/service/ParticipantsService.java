package com.funfit.service;

import java.util.List;

import com.funfit.bean.Participants;
import com.funfit.dao.ParticipantsDao;

public class ParticipantsService {
	ParticipantsDao participantsDao = new ParticipantsDao();

	public String addParticipant(int batchId, String participantName, String sex, int age) {
		participantsDao.addParticipant(batchId, participantName, sex, age);
		return "Participant added";
	}

	public List<Participants> listAllParticipants() {
		return participantsDao.listAllParticipants();
	}

	public String updateParticipant(Participants p) {
		if (participantsDao.updateParticipant(p) > 0) {
			return "Participant updated successfully";
		} else {
			return "Participant not present";
		}

	}

	public String deleteParticipant(int id) {
		if (participantsDao.deleteParticipant(id) > 0) {
			return "Participant " + id + " deleted.";
		} else {
			return "Participant  " + id + "  not present";
		}

	}

}
