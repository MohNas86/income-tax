package com.st.kata.code_tax_income;

import java.math.BigDecimal;

public class House {

	private BigDecimal incomeFather;
	private BigDecimal incomeMother;
	private Integer numberChildren;
	// Situation de la famille si monoparental singleParent is true sinon is
	// false
	private boolean singleParent;

	public House(BigDecimal incomeFather, BigDecimal incomeMother, Integer numberChildren, boolean singleParent) {
		super();
		this.incomeFather = incomeFather;
		this.incomeMother = incomeMother;
		this.numberChildren = numberChildren;
		this.singleParent = singleParent;
	}

	public BigDecimal getIncomeFather() {
		return incomeFather;
	}

	public void setIncomeFather(BigDecimal incomeFather) {
		this.incomeFather = incomeFather;
	}

	public BigDecimal getIncomeMother() {
		return incomeMother;
	}

	public void setIncomeMother(BigDecimal incomeMother) {
		this.incomeMother = incomeMother;
	}

	public Integer getNumberChildren() {
		return numberChildren;
	}

	public void setNumberChildren(Integer numberChildren) {
		this.numberChildren = numberChildren;
	}

	public boolean isSingleParent() {
		return singleParent;
	}

	public void setSingleParent(boolean singleParent) {
		this.singleParent = singleParent;
	}

	@Override
	public String toString() {
		return "House [incomeFather=" + incomeFather + ", incomeMother=" + incomeMother + ", numberChildren="
				+ numberChildren + ", singleParent=" + singleParent + "]";
	}

}
