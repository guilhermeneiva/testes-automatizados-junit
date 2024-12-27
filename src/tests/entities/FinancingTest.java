package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTest {

	@Test
	public void constructoShouldCreateObjectWhenDataIsValidate() {

		Financing f = FinancingFactory.createFinancing();

		Assertions.assertEquals(f.getTotalAmount(), 100000.0);
		Assertions.assertEquals(f.getIncome(), 2000.0);
		Assertions.assertEquals(f.getMonths(), 80);
	}

	@Test
	public void constructorShouldThrowExceptionWhenDataIsNotValid() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancingInvalid();
		});

	}

	@Test
	public void setTotalAmountShouldUpdateValueWhenDataIsValid() {
		Financing f = FinancingFactory.createFinancing();

		f.setTotalAmount(90000.0);

		Assertions.assertEquals(f.getTotalAmount(), 90000.0);
	}

	@Test
	public void setTotalAmountShouldThrowExceptionWhenDataIsInvalid() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing();
			f.setTotalAmount(110000.0);
		});
	}

	@Test
	public void setIncomeShouldUpdateValueWhenDataIsValid() {

		Financing f = FinancingFactory.createFinancing();

		f.setIncome(2500.0);

		Assertions.assertEquals(f.getIncome(), 2500.0);
	}

	@Test
	public void setIncomeShouldThrowExceptionWhenDataIsInvalid() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing();

			f.setIncome(1500.0);
		});
	}

	@Test
	public void setMonthsShouldUpdateValueWhenDataIsValid() {

		Financing f = FinancingFactory.createFinancing();

		f.setMonths(100);

		Assertions.assertEquals(f.getMonths(), 100);

	}

	@Test
	public void setMonthShouldThrowExceptionWhenDataIsInvalid() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing();
			f.setMonths(40);
		});
	}

	@Test
	public void entryShouldCorrectlyCalculateTheInputValue() {

		Financing f = FinancingFactory.createFinancing();

		Assertions.assertEquals(f.entry(), 20000.0);
	}

	@Test
	public void quotaShouldCorrectlyCalculateTheValueOfTheInstallment() {

		Financing f = FinancingFactory.createFinancing();

		Assertions.assertEquals(f.quota(), 1000.0);
	}
}
