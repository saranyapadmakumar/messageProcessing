/**
 * 
 */
package com.jpmc.exercise.utils;

/**
 * @author saranya
 *
 */
public class PriceCalculation {
	
	/**
	 * This method returns the double value of product price.
	 * @param productValue e.g 20p
	 *
	 * @return 20
	 */
	public double getDoubleValue(String productValue){
		double priceValue = 0.0;
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		for(char c:productValue.toCharArray()){
			if(Character.isDigit(c)){
				sb.append(c);
				found = true;
			}else if(found){
				break;
			}
		}
		
		if(productValue.contains("p")){
			productValue = sb.toString();
			priceValue = Double.parseDouble(productValue);
			//priceValue = priceValue/100;
		}else if(productValue.contains("£")){
			
		}
		return priceValue;
	}

}
