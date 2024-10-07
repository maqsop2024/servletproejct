package com.funfit.bean;

public class Participants {

	private int participantId;
	private int batchId;
	private String batchName;
	private String fullName;
	private String sex;
	private int age;

	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Participants [participantId=" + participantId + ", batchId=" + batchId + "  ,batchName=" + batchName
				+ ", fullName=" + fullName + ", sex=" + sex + ", age=" + age + "]";
	}

}
