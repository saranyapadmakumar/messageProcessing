package com.jpmc.exercise.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import org.apache.log4j.Logger;

import com.jpmc.exercise.utils.CustomMessages;
import com.jpmc.exercise.utils.MessagePattern;
import com.jpmc.exercise.utils.PriceCalculation;

import com.jpmc.exercise.model.SaleDetails;
import com.jpmc.exercise.model.MessageRecord;
import com.jpmc.exercise.model.ProductRecord;
import com.jpmc.exercise.model.AdjustmentDetails;
/**
 * @author saranya
 *
 */

public class MessageParser{
	
	static Logger logMessage = Logger.getLogger(MessageParser.class);
	private static  MessageParser messageParser = new MessageParser();
	private MessagePattern messagePattern = new MessagePattern();
	private PriceCalculation priceCalculation = new PriceCalculation();
	private ProductRecord productRegister = new ProductRecord();
	public static int count = 0;
	
	List<MessageRecord> messagesList = new ArrayList<MessageRecord>();
	
	public Map<String,ProductRecord> productMap = new HashMap();
	public static Map<String,List<SaleDetails>> salesReport = new TreeMap();
	
	/**
	 * This method returns the instance of MessageParser
	 * @return messageParser
	 */
	public static MessageParser getInstance(){
		return messageParser;
	}	
	
	/**
	 * This method processes and records every message.
	 * 
	 * @param inputMessage
	 */
	public void processMessage(String inputMessage){
		//logMessage.debug("Retrieving the message type from the input message");
		
			String messageType = messagePattern.getMessageType(inputMessage);
			
			if(messageType!=null && messageType !=""){
				count++;
				recordInputMessages(count,messageType,inputMessage);
				parseInputMessages(messageType,inputMessage);
			
			}else{
				logMessage.error(CustomMessages.INVALID_MESSAGE_FORMAT);	
				throw new IllegalArgumentException (CustomMessages.INVALID_MESSAGE_FORMAT + " " + inputMessage);
			} 
		
			
		
	}
	
	/**
	 * This method keeps a list of messages and their type, as received.
	 * @param count
	 * @param messageType
	 * @param inputMessage
	 */
	public void recordInputMessages(int count,String messageType,String inputMessage){
		
		MessageRecord messageRecord = new MessageRecord();
		messageRecord.setIndex(count);
		messageRecord.setInputMessage(inputMessage);
		messageRecord.setMessageType(messageType);
		messagesList.add(messageRecord);
				
	}
	
	/**
	 * This method splits the input message by white space
	 * and based on the messageType redirects the respective message parsing method.
	 * 
	 * @param messageType
	 * @param inputMessage
	 */
	public void parseInputMessages(String messageType,String inputMessage){
		String tempMessage = inputMessage;
		String[] messageTokens = tempMessage.trim().split("\\s+");
		switch(messageType){
		case MessagePattern.MESSAGE_TYPE_ONE: parseSingleSaleMessage(messageTokens);break;
		case MessagePattern.MESSAGE_TYPE_TWO: parseMultipleSaleMessage(messageTokens);break;
		case MessagePattern.MESSAGE_TYPE_THREE:adjustmentSaleMessage(messageTokens);break;
		}
		
	}
	
	
	/**
	 * This method parses the single sale message and adds to the SalesRegister
	 * @param messageTokens
	 */
	public void parseSingleSaleMessage(String[] messageTokens){
		double priceValue = priceCalculation.getDoubleValue(
				messageTokens[MessagePattern.SINGLE_PRODUCT_VALUE_INDEX]);
		
		String productName = updateProductRegister(
				messageTokens[MessagePattern.SINGLE_PRODUCT_INDEX]);
		
		addToSalesRegister(productName,MessagePattern.SINGLE_PRODUCT_QUANTITY,priceValue);
		
	}
	
	
	/**
	 * This method parses the multiple sale message and adds to the SalesRegister
	 * @param messageTokens
	 */
	public void parseMultipleSaleMessage(String[] messageTokens){
		double priceValue = priceCalculation.getDoubleValue(
				messageTokens[MessagePattern.MULTIPLE_PRODUCT_VALUE_INDEX]);
		String productName = updateProductRegister(
				messageTokens[MessagePattern.MULTIPLE_PRODUCT_INDEX]);
		int prodQty = Integer.parseInt(
				messageTokens[MessagePattern.MULTIPLE_PRODUCT_QUANTITY]);
		addToSalesRegister(productName,prodQty,priceValue);
		
	}
	
	/**
	 * This method parses the adjustment sale message and updates the SalesRegister
	 * @param messageTokens
	 */
	public void adjustmentSaleMessage(String[] messageTokens){
		double priceValue = priceCalculation.getDoubleValue(
				messageTokens[MessagePattern.ADJUSTMENT_PRODUCT_VALUE_INDEX]);
		String productName = updateProductRegister(
				messageTokens[MessagePattern.ADJUSTMENT_PRODUCT_INDEX]);
		String adjustmentOp = messageTokens[MessagePattern.ADJUSTMENT_OPERATION_INDEX];
		adjustSalesRegister(productName,adjustmentOp,priceValue);
	}
	
	
	/**
	 * This method keeps a record of the products sold and their id.
	 * This is to maintain a uniform product code.
	 * 
	 * @param product
	 * @return the product name in upper case.
	 */
	public String updateProductRegister(String product){
		String productCode = product.toUpperCase().substring(0, messagePattern.PRODUCT_CODE_LEN);
		if(productMap!=null){
			if(productMap.get(productCode) == null){
				//productMap.put(productCode, product.toUpperCase());
				ProductRecord productRecord = new ProductRecord();
				productRecord.setProductCode(productCode);
				productRecord.setProductType(product);
				productMap.put(productCode, productRecord);
			}
		}
		return productMap.get(productCode).getProductType().toUpperCase();
	}
	
	/**
	 * This method adds the sale details of each product to a map
	 * @param productName
	 * @param quantity
	 * @param value
	 */
	public void addToSalesRegister(String productName,int quantity,double value){
		
		SaleDetails saleDtls = new SaleDetails();
		saleDtls.populateSaleDetails(productName,quantity,value);
				
		if(salesReport!=null){
			if(salesReport.get(productName) == null){
				
				List<SaleDetails> salesList = new LinkedList<SaleDetails>();
				salesList.add(saleDtls);
				salesReport.put(productName, salesList);
			}else{
				salesReport.get(productName).add(saleDtls);
			}
			
		}
		
	}
	
	/**
	 * This method adjusts the sales for a particular product by the new value.
	 * 
	 * @param productName
	 * @param operation
	 * @param value
	 */
	public void adjustSalesRegister(String productName,String operation,double value){
		
		if(salesReport!=null){
			if(salesReport.get(productName) == null){
				logMessage.error(CustomMessages.INVALID_ADJUSTMENT);
				throw new IllegalArgumentException(CustomMessages.INVALID_ADJUSTMENT);
				
			}else{
				
				int listCount = salesReport.get(productName).size();
				for(int i=0;i<listCount; i++){
					
					int tempQty = salesReport.get(productName).get(i).getProductQuantity();
					double oldVal = salesReport.get(productName).get(i).getTotalValue();
					oldVal = oldVal/tempQty;
					double newVal = 0.0;
					double newAdjVal = 0.0;
					
					switch(operation.toUpperCase()){
						case MessagePattern.ADJUST_ADD :
							newAdjVal = oldVal + value;
							newVal = newAdjVal * tempQty;
							break;
						case MessagePattern.ADJUST_SUBTRACT: 
							if(oldVal<value){
								logMessage.error(CustomMessages.INVALID_SUBRACT);
								throw new ArithmeticException(CustomMessages.INVALID_SUBRACT);
								
							}else{
								newAdjVal = oldVal-value;
								newVal = newAdjVal * tempQty;
							}
							break;
						case MessagePattern.ADJUST_MULTIPLY:
							newAdjVal = oldVal*value; 
							newVal = newAdjVal * tempQty;
							break;
					}
					
					AdjustmentDetails adjDtls = new AdjustmentDetails();
					adjDtls.setUnitValueBeforeAdjustment(oldVal);
					adjDtls.setProduct(productName);
					adjDtls.setAdjustmentValue(value);
					adjDtls.setAdjustmentOp(operation);
					adjDtls.setAdjustedUnitValue(newAdjVal);
					List<AdjustmentDetails> adjDtlsList = salesReport.get(productName).get(i).getAdjustmentDetails();
					if(adjDtlsList!=null){
						adjDtlsList.add(adjDtls);
						
					}else{
						adjDtlsList  = new LinkedList<AdjustmentDetails>();
						adjDtlsList.add(adjDtls);
					}
					salesReport.get(productName).get(i).setTotalValue(newVal);
					salesReport.get(productName).get(i).setAdjusted(true);
					salesReport.get(productName).get(i).setUnitValue(newAdjVal);
					salesReport.get(productName).get(i).setAdjustmentDetails(adjDtlsList);
				}
			}
			
			
		}
		
	}

	
}
