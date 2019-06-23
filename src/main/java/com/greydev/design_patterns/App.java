package com.greydev.design_patterns;

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

	}

	private static void observerPatternDemo() {
		System.out.println("----- Observer Pattern -----");

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
		System.out.println();
	}

	public static void strategyPatternDemo() {
		System.out.println("----- Strategy Pattern -----");

		MyCollection collectionDefaultSorting = new MyCollection();
		collectionDefaultSorting.sortString("blabla");

		MyCollection collectionWithBubbleSort = new MyCollection(new BubbleSort());
		collectionWithBubbleSort.sortString("blabla");

		Sedan sedan = new Sedan();
		sedan.applyBrake();

		SUV suv = new SUV();
		suv.applyBrake();
		System.out.println();
	}
}
