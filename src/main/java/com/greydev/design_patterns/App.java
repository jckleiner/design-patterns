package com.greydev.design_patterns;

import com.greydev.design_patterns.decorator.pizza.CheeseDecorator;
import com.greydev.design_patterns.decorator.pizza.IPizzaComponent;
import com.greydev.design_patterns.decorator.pizza.PlainPizzaComponent;
import com.greydev.design_patterns.decorator.pizza.SucukDecorator;
import com.greydev.design_patterns.observer.weatherstation.CarDisplay;
import com.greydev.design_patterns.observer.weatherstation.PhoneDisplay;
import com.greydev.design_patterns.observer.weatherstation.WeatherStation;
import com.greydev.design_patterns.strategy.brake.SUV;
import com.greydev.design_patterns.strategy.brake.Sedan;
import com.greydev.design_patterns.strategy.sort.BubbleSort;
import com.greydev.design_patterns.strategy.sort.MyCollection;

public class App {

	public static void main(String[] args) {

		strategyPatternDemo();

		observerPatternDemo();

		decoratorPatternDemo();

	}

	private static void decoratorPatternDemo() {
		System.out.println("\n----- Decorator Pattern -----");
		PlainPizzaComponent plainPizza = new PlainPizzaComponent();
		displayPizzaInfo(plainPizza);
		CheeseDecorator cheseDecorator = new CheeseDecorator(plainPizza);
		displayPizzaInfo(cheseDecorator);
		SucukDecorator sucukDecorator = new SucukDecorator(cheseDecorator);
		displayPizzaInfo(sucukDecorator);
		// cheese or sucuk decorators cannot exists without a concrete IPizzaComponent
	}

	private static void displayPizzaInfo(IPizzaComponent pizza) {
		System.out.println(pizza.getDescription() + ", cost: " + pizza.cost() + "$");
	}

	private static void observerPatternDemo() {
		System.out.println("\n----- Observer Pattern -----");

		WeatherStation weatherStation = new WeatherStation();
		weatherStation.setCurrentTemp(15);

		CarDisplay carDisplay = new CarDisplay(weatherStation);
		carDisplay.showCurrentTemparature();
		PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
		phoneDisplay.showCurrentTemparature();

		System.out.println("*** temp is updated ***");
		weatherStation.setCurrentTemp(20);
		carDisplay.showCurrentTemparature();
		phoneDisplay.showCurrentTemparature();
	}

	public static void strategyPatternDemo() {
		System.out.println("\n----- Strategy Pattern -----");

		MyCollection collectionDefaultSorting = new MyCollection();
		collectionDefaultSorting.sortString("blabla");

		MyCollection collectionWithBubbleSort = new MyCollection(new BubbleSort());
		collectionWithBubbleSort.sortString("blabla");

		Sedan sedan = new Sedan();
		sedan.applyBrake();

		SUV suv = new SUV();
		suv.applyBrake();
	}
}
