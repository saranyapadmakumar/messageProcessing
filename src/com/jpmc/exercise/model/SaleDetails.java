/**
 * 
 */
package com.jpmc.exercise.model;
import java.util.List;

/**
 * @author saranya
 *
 */
public class SaleDetails {
	
	private String product;
	private int productQuantity;
	private double unitValue;
	private double totalValue;
	private boolean isAdjusted;
	private String adjustmentOp;
	private double adjustmentValue;
	private double adjustedUnitValue;
	private double adjustedTotalValue;
	private List<AdjustmentDetails> adjustmentDetails;
	
	
	
	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}
	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	/**
	 * @return the unitValue
	 */
	public double getUnitValue() {
		return unitValue;
	}
	/**
	 * @param unitValue the unitValue to set
	 */
	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}
	/**
	 * @return the totalvalue
	 */
	public double getTotalValue() {
		return totalValue;
	}
	/**
	 * @param totalvalue the totalvalue to set
	 */
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	/**
	 * @return the isAdjusted
	 */
	public boolean isAdjusted() {
		return isAdjusted;
	}
	/**
	 * @param isAdjusted the isAdjusted to set
	 */
	public void setAdjusted(boolean isAdjusted) {
		this.isAdjusted = isAdjusted;
	}
	/**
	 * @return the adjustmentOp
	 */
	public String getAdjustmentOp() {
		return adjustmentOp;
	}
	/**
	 * @param adjustmentOp the adjustmentOp to set
	 */
	public void setAdjustmentOp(String adjustmentOp) {
		this.adjustmentOp = adjustmentOp;
	}
	/**
	 * @return the adjustmentValue
	 */
	public double getAdjustmentValue() {
		return adjustmentValue;
	}
	/**
	 * @param adjustmentValue the adjustmentValue to set
	 */
	public void setAdjustmentValue(double adjustmentValue) {
		this.adjustmentValue = adjustmentValue;
	}
	/**
	 * @return the adjustedUnitValue
	 */
	public double getAdjustedUnitValue() {
		return adjustedUnitValue;
	}
	/**
	 * @param adjustedUnitValue the adjustedUnitValue to set
	 */
	public void setAdjustedUnitValue(double adjustedUnitValue) {
		this.adjustedUnitValue = adjustedUnitValue;
	}
	/**
	 * @return the adjustedTotalValue
	 */
	public double getAdjustedTotalValue() {
		return adjustedTotalValue;
	}
	/**
	 * @param adjustedTotalValue the adjustedTotalValue to set
	 */
	public void setAdjustedTotalValue(double adjustedTotalValue) {
		this.adjustedTotalValue = adjustedTotalValue;
	}
	
	/**
	 * @return the adjustmentDetails
	 */
	public List<AdjustmentDetails> getAdjustmentDetails() {
		return adjustmentDetails;
	}
	/**
	 * @param adjustmentDetails the adjustmentDetails to set
	 */
	public void setAdjustmentDetails(List<AdjustmentDetails> adjustmentDetails) {
		this.adjustmentDetails = adjustmentDetails;
	}
	
	
	/**
	 * 
	 * This method populates the details of each sale.
	 * 
	 * @param product
	 * @param quantity
	 * @param value
	 */
	public void populateSaleDetails(String product,int quantity,double value){
		
		this.setProduct(product);
		this.setUnitValue(value);
		this.setTotalValue(value * quantity);
		this.setProductQuantity(quantity);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*public String toString(){
		String saleDetailStr = System.getProperty("line.separator") +
				"Product = " + this.getProduct() + 
				" | Quantity = " + this.getProductQuantity() +
				" | Unit Value = " + this.getUnitValue()+
				" | Total Value = " + this.getTotalValue();
		
				if(this.isAdjusted){
					saleDetailStr = saleDetailStr + " | Adjustments = " + this.getAdjustmentDetails() ;
				}else{
					saleDetailStr = saleDetailStr + " | No Adjustments";
				}
				
			return saleDetailStr;	
	}*/

}
