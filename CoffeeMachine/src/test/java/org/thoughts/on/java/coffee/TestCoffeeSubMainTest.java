package org.thoughts.on.java.coffee;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCoffeeSubMainTest {
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
}