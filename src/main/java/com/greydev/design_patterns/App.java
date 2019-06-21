package com.greydev.design_patterns;

import com.greydev.design_patterns.strategy.brake.SUV;
import com.greydev.design_patterns.strategy.brake.Sedan;
import com.greydev.design_patterns.strategy.sort.BubbleSort;
import com.greydev.design_patterns.strategy.sort.MyCollection;

public class App {

	public static void main(String[] args) {
		startStrategyPatternDemo();
	}

	public static void startStrategyPatternDemo() {
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
