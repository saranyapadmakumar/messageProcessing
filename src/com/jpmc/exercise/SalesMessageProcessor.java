/**
 * 
 */
package com.jpmc.exercise;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;

import com.jpmc.exercise.parser.MessageParser;
import com.jpmc.exercise.utils.CustomMessages;
import com.jpmc.exercise.utils.MessagePattern;
import com.jpmc.exercise.view.SalesReports;

/**
 * @author saranya
 *
 */
public class SalesMessageProcessor {

	
	static Logger logger = Logger.getLogger(SalesMessageProcessor.class);
	 
	/**
	 * Main method
	 * This method reads the message from an input text file.
	 * 
	 * @param args
	 * @exception - for invalid input error.
	 * @see Exception
	 */
	public static void main(String[] args) {
		
		
		String inputMessage;
		MessageParser messageParser = MessageParser.getInstance();
		
		try{
			BufferedReader inputReader = new BufferedReader(new FileReader("test/testInput_MoreThan50.txt"));
			
			while((inputMessage = inputReader.readLine()) != null){
				
				logger.debug("Reading input message : " + inputMessage);
				
				messageParser.processMessage(inputMessage);
				//Print sales report after every 10 messages.
				if((MessageParser.count % MessagePattern.INTERIM_SALES_COUNT) == 0){
					//System.out.println("Successfully read " + MessageParser.count + " messages");
					SalesReports interimReport = new SalesReports();
					interimReport.getInterimSalesReport(MessageParser.count);
				}
				//Print adjustment report after every 50 messages.
				if(((MessageParser.count % MessagePattern.REPORT_LENGTH) == 0) && 
						(MessageParser.count<= MessagePattern.MAX_NO_OF_MESSAGES) ) {
					System.out.println(CustomMessages.SYSTEM_PAUSE);
					SalesReports finalReport = new SalesReports();
					finalReport.getAdjustmentSalesReport();
					//System.out.println("System paused. Please wait for a few seconds");
					//System.exit(1);
					Thread.sleep(5000);//sleep for 5 seconds and resume
					System.out.println(CustomMessages.SYSTEM_RESUME);
				}
			}
				
			inputReader.close();
		}catch(java.io.IOException e){
			logger.error("Error occurred while reading the input message");
			e.printStackTrace();
		}catch(InterruptedException e){
			logger.error("Unable to resume.Please try again later");
			Thread.currentThread().interrupt();
		}
		
		
     
	}

}
