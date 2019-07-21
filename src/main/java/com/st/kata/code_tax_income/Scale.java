package com.st.kata.code_tax_income;

import java.math.BigDecimal;

public interface Scale {

	public static final double LIMIT_1 = 0.45;
	public static final double LIMIT_2 = 0.41;
	public static final double LIMIT_3 = 0.30;
	public static final double LIMIT_4 = 0.14;
	public static final double LIMIT_5 = 0.00;
	public static final BigDecimal amoutIncome_1 = new BigDecimal(156244.00);
	public static final BigDecimal amoutIncome_2 = new BigDecimal(73779.00);
	public static final BigDecimal amoutIncome_3 = new BigDecimal(27519.00);
	public static final BigDecimal amoutIncome_4 = new BigDecimal(9964.00);
	public static final BigDecimal amoutIncome_5 = new BigDecimal(0.00);

}
