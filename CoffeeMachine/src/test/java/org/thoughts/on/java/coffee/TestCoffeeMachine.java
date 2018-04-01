package org.thoughts.on.java.coffee;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestCoffeeMachine {

	@Test
	public void basicCoffeeMachineAsCoffeeMachine() throws CoffeeException {
		// create a Map of available coffee beans
		Map<CoffeeSelection, GroundCoffee> beans = new HashMap<CoffeeSelection, GroundCoffee>();
		beans.put(CoffeeSelection.FILTER_COFFEE, new GroundCoffee(
				"My favorite filter coffee bean", 1000));

		// instantiate a new CoffeeMachine object
		CoffeeMachine coffeeMachine = new BasicCoffeeMachine(beans);

		CoffeeDrink coffee = coffeeMachine.brewCoffee(CoffeeSelection.FILTER_COFFEE);
	}

	@Test
	public void premiumCoffeeMachineAsCoffeeMachine() throws CoffeeException {
		// create a Map of available coffee beans
		Map<CoffeeSelection, CoffeeBean> beans = new HashMap<CoffeeSelection, CoffeeBean>();
		beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean(
				"My favorite filter coffee bean", 1000));
		beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean(
				"My favorite espresso bean", 1000));

		// instantiate a new CoffeeMachine object
		CoffeeMachine coffeeMachine = new PremiumCoffeeMachine(beans);

		CoffeeDrink coffee = coffeeMachine.brewCoffee(CoffeeSelection.ESPRESSO);
	}
}
