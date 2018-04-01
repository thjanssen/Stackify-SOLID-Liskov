package org.thoughts.on.java.coffee;

import java.util.HashMap;
import java.util.Map;

public class PremiumCoffeeMachine implements CoffeeMachine {

	private Map<CoffeeSelection, Configuration> configMap;

	private Map<CoffeeSelection, CoffeeBean> beans;
	
	private Grinder grinder;
	
	private BrewingUnit brewingUnit;
	
	public PremiumCoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
		this.beans = beans;
		this.grinder = new Grinder();
		this.brewingUnit = new BrewingUnit();
		
		this.configMap = new HashMap<>();
		this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
		this.configMap.put(CoffeeSelection.ESPRESSO, new Configuration(8, 28));
	}

	@Override
	public CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException {
		switch(selection) {
		case ESPRESSO:
			return brewEspresso();
			
		case FILTER_COFFEE:
			return brewFilterCoffee();
			
		default:
			throw new CoffeeException("CoffeeSelection ["+selection+"] not supported!");
		}
	}
	
	private CoffeeDrink brewEspresso() {
		Configuration config = configMap.get(CoffeeSelection.ESPRESSO);

		// grind the coffee beans
		GroundCoffee groundCoffee = this.grinder.grind(
				this.beans.get(CoffeeSelection.ESPRESSO),
				config.getQuantityCoffee());

		// brew an espresso
		return this.brewingUnit.brew(CoffeeSelection.ESPRESSO, groundCoffee,
				config.getQuantityWater());
	}
	
	private CoffeeDrink brewFilterCoffee() {
		Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

		// grind the coffee beans
		GroundCoffee groundCoffee = this.grinder.grind(
				this.beans.get(CoffeeSelection.FILTER_COFFEE),
				config.getQuantityCoffee());

		// brew a filter coffee
		return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee,
				config.getQuantityWater());
	}
	
	public void addCoffee(CoffeeSelection sel, CoffeeBean newBeans) throws CoffeeException {
		CoffeeBean existingBeans = this.beans.get(sel);
		if (existingBeans != null) {
			if (existingBeans.getName().equals(newBeans.getName())) {
				existingBeans.setQuantity(existingBeans.getQuantity() + newBeans.getQuantity());
			} else {
				throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
			}
		} else {
			this.beans.put(sel, newBeans);
		}
	}
}
