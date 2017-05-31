package com.jpmc.exercise.utils;

import java.util.regex.Pattern;

public class MessagePattern {
	// constants for message pattern matching
	public static final String SINGLE_SALE_PATTERN = "(\\w+)\\sat\\s(\\d+)p$";
	public static final String MULTIPLE_SALE_PATTERN = "(\\d+)\\ssales\\sof\\s(\\w+)\\sat\\s(\\d+)p\\seach$";
	public static final String ADJUSTMENT_SALE_PATTERN = "(Add|Subtract|Multiply)\\s(\\d+)p\\s(\\w+)$";
	// constants for message type
	public static final String MESSAGE_TYPE_ONE = "SINGLE";
	public static final String MESSAGE_TYPE_TWO = "MULTIPLE";
	public static final String MESSAGE_TYPE_THREE = "ADJUSTMENT";
	//constants for the single sale indices
	public static final int SINGLE_PRODUCT_INDEX = 0;
	public static final int SINGLE_PRODUCT_QUANTITY = 1;
	public static final int SINGLE_PRODUCT_VALUE_INDEX = 2;
	//constants for the multiple sale indices
	public static final int MULTIPLE_PRODUCT_INDEX = 3;
	public static final int MULTIPLE_PRODUCT_QUANTITY = 0;
	public static final int MULTIPLE_PRODUCT_VALUE_INDEX = 5;
	//constants for the adjustment sale indices
	public static final int ADJUSTMENT_PRODUCT_INDEX = 2;
	public static final int ADJUSTMENT_OPERATION_INDEX = 0;
	public static final int ADJUSTMENT_PRODUCT_VALUE_INDEX = 1;
	//constants for the adjustment operation
	public static final String ADJUST_ADD = "ADD";
	public static final String ADJUST_SUBTRACT = "SUBTRACT";
	public static final String ADJUST_MULTIPLY = "MULTIPLY";
	// product code length
	public static final int PRODUCT_CODE_LEN = 4;
	// constants for the report generation
	public static final int INTERIM_SALES_COUNT = 10;
	public static final int REPORT_LENGTH = 50;
	public static final int MAX_NO_OF_MESSAGES = 250;
	
	/**
	 * This method verifies the message pattern and returns the messageType
	 * @param inputMessage
	 * @return
	 */
	public String  getMessageType(String inputMessage){
		
		String tempMessage = inputMessage;
		String messageType = "";
		
		Pattern singleSalePattern = Pattern.compile(SINGLE_SALE_PATTERN);
		Pattern multipleSalePattern = Pattern.compile(MULTIPLE_SALE_PATTERN);
		Pattern adjustmentSalePattern = Pattern.compile(ADJUSTMENT_SALE_PATTERN);
		if(singleSalePattern.matcher(tempMessage).matches()){
			messageType = MESSAGE_TYPE_ONE;
		}else if(multipleSalePattern.matcher(tempMessage).matches()){
			messageType =  MESSAGE_TYPE_TWO;
		}else if(adjustmentSalePattern.matcher(tempMessage).matches()){
			messageType =  MESSAGE_TYPE_THREE;
		}
		
		return messageType;
	}

}
