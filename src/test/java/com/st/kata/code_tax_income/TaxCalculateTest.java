package com.st.kata.code_tax_income;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.st.kata.code_tax_income.service.CalculateTax;

public class TaxCalculateTest {

	private Quotient quotient;
	private House house;

	@Before
	public void init() throws Exception {
		house = new House(new BigDecimal("25950.00"), new BigDecimal("30000.00"), 2, false);
	}

	/* calcul le nombre de parts de quotient familial */

	@Test
	public void getQuotientTest() throws Exception {

		assertEquals(2.00, CalculateTax.getQuotient(quotient, 2, true), Double.MIN_VALUE);
	}

	/* Calcul la somme du revenu net imposable */

	@Test
	public void getIncomeHouseTest() throws Exception {

		assertEquals(55950.00, CalculateTax.getIncomeHouse(house));
	}

	/*
	 * Diviser le revenu net imposable par votre nombre de parts de quotient
	 * familial
	 */
	@Test
	public void getDivideIncomeToQuotientTest() throws Exception {

		assertEquals(27975.00, CalculateTax.getDivideIncomeToQuotient(2.00, new BigDecimal("55950.00")));
	}

}
