/**
 * 
 */
package com.jpmc.exercise.view;

import java.util.List;
import java.util.Map;

import com.jpmc.exercise.model.SaleDetails;
import com.jpmc.exercise.model.AdjustmentDetails;
import com.jpmc.exercise.parser.MessageParser;
/**
 * @author saranya
 *
 */

public class SalesReports {
	
	/**
	 * This method generates a report after every 10 messages.
	 */
	public void getInterimSalesReport(int count){
		System.out.println("***********************************");
		System.out.println("Sales report after " + count + " messages" );
		System.out.println("***********************************");
		
		for (Map.Entry<String,List<SaleDetails>> entry : MessageParser.salesReport.entrySet()){
			
			String key = entry.getKey();
			int totalQuantity = 0;
			double totalValue =0.0;
			List<SaleDetails> tempList = entry.getValue();
			for(int i=0;i<tempList.size();i++){
				totalQuantity += tempList.get(i).getProductQuantity();
				totalValue += tempList.get(i).getTotalValue();
			}
		    System.out.println("Product = " + entry.getKey() + 
		    						" | No: of Sales = " + totalQuantity +
		    						" | Total Value(£) = " + (totalValue/100));
		    System.out.println("------------------------------------------------------------------");
		}
						
	}
	
	/**
	 * This method displays the adjustment details of each sale type recorded for each product
	 */
	public void getAdjustmentSalesReport(){
				
		for (Map.Entry<String,List<SaleDetails>> entry : MessageParser.salesReport.entrySet()){
			List<SaleDetails> saleDetailsData = entry.getValue();
			System.out.println("---------------------------------------------------");
			System.out.println("Adjustment Report for product :" +entry.getKey());
			System.out.println("---------------------------------------------------");
			
			
			
			for(int i = 0;i<saleDetailsData.size();i++){
				System.out.println(".........................");
				System.out.println("Sale record : " + (i + 1));
				System.out.println(".........................");
				System.out.println("No: of Sales = " + saleDetailsData.get(i).getProductQuantity()
												 + " | Total Value(£) = " + (saleDetailsData.get(i).getTotalValue()/100));
				
				//System.out.printf("Value: %.2f", (saleDetailsData.get(i).getTotalValue()/100));
						System.out.println("");
				List<AdjustmentDetails> adjDtlsList = saleDetailsData.get(i).getAdjustmentDetails();
				if(adjDtlsList != null){
					System.out.println("Adjustment details:");
					System.out.println("");
					for(int j= 0; j<saleDetailsData.get(i).getAdjustmentDetails().size();j++){
						System.out.println((j+1) + "." + " Unit Value before adjustment: " + adjDtlsList.get(j).getUnitValueBeforeAdjustment() + 
											" | Adjustment type: " +adjDtlsList.get(j).getAdjustmentOp() +
											" | Adjustment value: " + adjDtlsList.get(j).getAdjustmentValue() +
											" | Unit Value after adjustment: " + adjDtlsList.get(j).getAdjustedUnitValue());
					}
				
				}else{
					System.out.println("No adjustments made for this sale record");
				}
				System.out.println("");
			}
			
			
		}
			
	}

}
