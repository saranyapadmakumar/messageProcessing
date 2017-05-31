/**
 * 
 */
package com.jpmc.exercise.model;

/**
 * @author saranya
 *
 */
public class AdjustmentDetails {
	
	private boolean isAdjusted;
	private String product;
	private String adjustmentOp;
	private double adjustmentValue;
	private double adjustedUnitValue;
	private double adjustedTotalValue;
	private double unitValueBeforeAdjustment;
	
	
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
	 * @return the unitValueBeforeAdjustment
	 */
	public double getUnitValueBeforeAdjustment() {
		return unitValueBeforeAdjustment;
	}
	/**
	 * @param unitValueBeforeAdjustment the unitValueBeforeAdjustment to set
	 */
	public void setUnitValueBeforeAdjustment(double unitValueBeforeAdjustment) {
		this.unitValueBeforeAdjustment = unitValueBeforeAdjustment;
	}
	public String toString(){
		return "Product = " + this.getProduct() + 
				" | Unit value before adjustment = " + this.getUnitValueBeforeAdjustment()+
				" | Adjustment type = "+ this.getAdjustmentOp()+
				" | Adjustment value = " + this.getAdjustmentValue()+
				" | Unit Value after Adjustment = " + this.getAdjustedUnitValue()+
				//" Total Value = " + this.getTotalValue()+
				System.getProperty("line.separator");
	}

}
