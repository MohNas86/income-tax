package com.st.kata.code_tax_income.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.st.kata.code_tax_income.House;
import com.st.kata.code_tax_income.Quotient;
import com.st.kata.code_tax_income.Scale;

public class CalculateTax {

	public static double quotientFamily = 0;
	public static BigDecimal incomeHouse;
	public static BigDecimal divideIncomeToQuotient = new BigDecimal(0);
	public static BigDecimal incomeAfterApplyScale;
	public static BigDecimal totalSlice1;
	public static BigDecimal totalSlice2;
	public static BigDecimal totalSlice3;
	public static BigDecimal totalSlice4;
	public static BigDecimal totalSlice5;

	public static double getQuotient(Quotient quotient, Integer numberOfChildren, boolean isSingleParent) {

		if (isSingleParent == true) {
			quotientFamily = (numberOfChildren * Quotient.Q_CHILD) + 1;
		}

		else if (isSingleParent == false) {
			quotientFamily = (numberOfChildren * Quotient.Q_CHILD) + 2;
		}

		return quotientFamily;
	}

	public static BigDecimal getIncomeHouse(House house) {
		incomeHouse = house.getIncomeFather().add(house.getIncomeMother());
		return incomeHouse;
	}

	public static BigDecimal getDivideIncomeToQuotient(double quotientFamily, BigDecimal incomeHouse) {
		BigDecimal q_family = new BigDecimal(quotientFamily);
		return divideIncomeToQuotient = incomeHouse.divide(q_family, 3, RoundingMode.CEILING);

	}

	public static BigDecimal getApplyScaleToIncome(Scale scale, BigDecimal divideIncomeToQuotient) {
		if (divideIncomeToQuotient.compareTo(scale.amoutIncome_4) <= 0) {
			incomeAfterApplyScale = new BigDecimal(0.00);
		}

		if (divideIncomeToQuotient.compareTo(Scale.amoutIncome_4) > 0
				&& divideIncomeToQuotient.compareTo(Scale.amoutIncome_3) <= 0) {
			incomeAfterApplyScale = (divideIncomeToQuotient.subtract(Scale.amoutIncome_4))
					.multiply(new BigDecimal(Scale.LIMIT_4));
		}

		if (divideIncomeToQuotient.compareTo(Scale.amoutIncome_3) > 0
				&& divideIncomeToQuotient.compareTo(Scale.amoutIncome_2) <= 0) {
			BigDecimal incomeAfterApplyScale_1;
			BigDecimal incomeAfterApplyScale_2;
			incomeAfterApplyScale_1 = (Scale.amoutIncome_3.subtract(Scale.amoutIncome_4))
					.multiply(new BigDecimal(Scale.LIMIT_4));
			incomeAfterApplyScale_2 = divideIncomeToQuotient.subtract(Scale.amoutIncome_3)
					.multiply(new BigDecimal(Scale.LIMIT_3));
			incomeAfterApplyScale = incomeAfterApplyScale_1.add(incomeAfterApplyScale_2);
		}

		if (divideIncomeToQuotient.compareTo(Scale.amoutIncome_2) > 0
				&& divideIncomeToQuotient.compareTo(Scale.amoutIncome_1) <= 0) {
			BigDecimal incomeAfterApplyScale_1;
			BigDecimal incomeAfterApplyScale_2;
			BigDecimal incomeAfterApplyScale_3;
			incomeAfterApplyScale_1 = (Scale.amoutIncome_3.subtract(Scale.amoutIncome_4))
					.multiply(new BigDecimal(Scale.LIMIT_4));
			incomeAfterApplyScale_2 = Scale.amoutIncome_2.subtract(Scale.amoutIncome_3)
					.multiply(new BigDecimal(Scale.LIMIT_3));
			incomeAfterApplyScale_3 = divideIncomeToQuotient.subtract(Scale.amoutIncome_2)
					.multiply(new BigDecimal(Scale.LIMIT_2));
			incomeAfterApplyScale = incomeAfterApplyScale_1.add(incomeAfterApplyScale_2.add(incomeAfterApplyScale_3));
		}

		if (divideIncomeToQuotient.compareTo(Scale.amoutIncome_1) > 0) {
			BigDecimal incomeAfterApplyScale_1;
			BigDecimal incomeAfterApplyScale_2;
			BigDecimal incomeAfterApplyScale_3;
			BigDecimal incomeAfterApplyScale_4;
			incomeAfterApplyScale_1 = (Scale.amoutIncome_3.subtract(Scale.amoutIncome_4))
					.multiply(new BigDecimal(Scale.LIMIT_4));
			incomeAfterApplyScale_2 = Scale.amoutIncome_2.subtract(Scale.amoutIncome_3)
					.multiply(new BigDecimal(Scale.LIMIT_3));
			incomeAfterApplyScale_3 = Scale.amoutIncome_1.subtract(Scale.amoutIncome_2)
					.multiply(new BigDecimal(Scale.LIMIT_2));
			incomeAfterApplyScale_4 = divideIncomeToQuotient.subtract(Scale.amoutIncome_1)
					.multiply(new BigDecimal(Scale.LIMIT_1));
			incomeAfterApplyScale = incomeAfterApplyScale_1
					.add(incomeAfterApplyScale_2.add(incomeAfterApplyScale_3.add(incomeAfterApplyScale_4)));
		}

		return incomeAfterApplyScale;

	}

	public static BigDecimal getTaxIncome(BigDecimal incomeAfterApplyScale, double quotientFamily) {
		BigDecimal taxIncome;
		BigDecimal q_family = new BigDecimal(quotientFamily);
		taxIncome = incomeAfterApplyScale.multiply(q_family);
		return taxIncome;
	}

}
