/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import task.Task;

class TaskTest {

	// test a valid task
	@Test
	void testTask() {
		// act
		Task task = new Task("1", "My Task", "My Description");
		
		// assert
		assertTrue(task.id().equals("1"));
		assertTrue(task.name().equals("My Task"));
		assertTrue(task.description().equals("My Description"));
	}
	
	// test an invalid id
	// null
	// >10 chars
	@ParameterizedTest
	@ValueSource(strings = {"12345678901"})
	@NullSource
	public void TestIdInvalid(String testId) {
		// assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Task(testId, "My Task", "My Description");
		});
		
	}
	
	// test an invalid name
	// null
	// >20 chars
	@ParameterizedTest
	@ValueSource(strings = {"123456789012345678901"})
	@NullSource
	public void TestNameInvalid(String testName) {
		// assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Task("1", testName, "My Description");
		});
		
	}
	
	// test an invalid description
	// null
	// >50 chars
	@ParameterizedTest
	@ValueSource(strings = {"123456789012345678901234567890123456789012345678901"})
	@NullSource
	public void TestDescriptionInvalid(String testDescription) {
		
		//assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// act
			new Task("1", "My Task", testDescription);
		});
	}
	
}
