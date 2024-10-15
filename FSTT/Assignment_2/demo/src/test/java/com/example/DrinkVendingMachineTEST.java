package com.example;

import org.junit.jupiter.api.*;

public class DrinkVendingMachineTEST {
	
	/** 
	 * Task 2:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.vendors.DrinkVendingMachine'
	 * 
	 * 	Goal: 
	 * 		80% code/line coverage
	 * 		TDD: analyse code and add missing methods.
	 * */
	private DrinkVendingMachine drinkVendingMachine;

    @BeforeEach
    public void setup() {
        drinkVendingMachine = new DrinkVendingMachine();
    }

	// Test the selecDrink method
	@Test
	public void testSelectDrink() {
		// set the available credit
		drinkVendingMachine.setAvailableCredit(10);
		Snack selectedDrink = drinkVendingMachine.selectDrink(1);
		
		// Check if the selected drink is VanillaBurst
		Assertions.assertEquals("VanillaBurst", selectedDrink.name);

		// Check if the available credit is 10 - 1.75
		Assertions.assertEquals(8.25, drinkVendingMachine.getAvailableCredit());
	}

	// Test the selectDrink method with not enough credit
	@Test
	public void testSelectDrinkNotEnoughCredit() {
		// set the available credit
		drinkVendingMachine.setAvailableCredit(0.5f);
		Snack selectedDrink = drinkVendingMachine.selectDrink(1);
		
		// Check if the selected drink is null
		Assertions.assertNull(selectedDrink);

		// Check if the available credit is 0.5
		Assertions.assertEquals(0.5, drinkVendingMachine.getAvailableCredit());
	}

	// Test the selectDrink method with invalid array position
	@Test
	public void testSelectDrinkInvalidArrayPosition() {
		// set the available credit
		drinkVendingMachine.setAvailableCredit(10);
		Snack selectedDrink = drinkVendingMachine.selectDrink(10);
		
		// Check if the selected drink is null
		Assertions.assertNull(selectedDrink);

		// Check if the available credit is 10
		Assertions.assertEquals(10, drinkVendingMachine.getAvailableCredit());
	}

	// Test the selectDrink method with not enough credit at firts and then enough credit
	@Test
	public void testSelectDrinkNotEnoughCreditAndThenEnoughCredit() {
		// set the available credit
		drinkVendingMachine.setAvailableCredit(0.5f);
		Snack selectedDrink = drinkVendingMachine.selectDrink(1);
		
		// Check if the selected drink is null
		Assertions.assertNull(selectedDrink);

		// Check if the available credit is 0.5
		Assertions.assertEquals(0.5, drinkVendingMachine.getAvailableCredit());

		// set the available credit
		drinkVendingMachine.setAvailableCredit(10);
		selectedDrink = drinkVendingMachine.selectDrink(1);
		
		// Check if the selected drink is VanillaBurst
		Assertions.assertEquals("VanillaBurst", selectedDrink.name);

		// Check if the available credit is 8.25
		Assertions.assertEquals(8.25, drinkVendingMachine.getAvailableCredit());
	}

	// Test the giveCredit method
	@Test
	public void testGiveCredit() {
		Wallet wallet = new Wallet(0);
		Person person = new Person("Davide", wallet);
		drinkVendingMachine.giveCredit(person, 10);
		
		// Check if the available credit is 20
		Assertions.assertEquals(10, drinkVendingMachine.getAvailableCredit());
	}
}

