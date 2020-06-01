package com.in28minutes.mockito;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void basicHamcrestMatchers() {
		List<Integer> scores = Arrays.asList(90,100,110,120,140,150);
		
		// Scores has 4 Items
		assertThat(scores, hasSize(6));
		
		assertThat(scores, hasItem(120));
		assertThat(scores, hasItems(90,150));
		
		
		assertThat(scores, everyItem(greaterThan(89)));
		assertThat(scores, everyItem(lessThan(170)));
		
		// String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		// Arrays
		Integer[] marks = {1,2,3};
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContaining(1,2,3));
		assertThat(marks, arrayContainingInAnyOrder(3,1,2));
		
	}
}
