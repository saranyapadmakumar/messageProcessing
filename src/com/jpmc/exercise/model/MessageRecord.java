package com.jpmc.exercise.model;

public class MessageRecord {
	
	private String inputMessage;
	private String messageType;
	private int index;
	
	/**
	 * @return the inputMessage
	 */
	public String getInputMessage() {
		return inputMessage;
	}

	/**
	 * @param inputMessage the inputMessage to set
	 */
	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}




	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}




	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}




	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}




	public String toString(){
		return getIndex() + " " + getMessageType() + " " + getInputMessage(); 
	}

}
