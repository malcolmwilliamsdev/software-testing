/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {

	// test adding tasks
	// test adding tasks with non-unique keys
	@Test
	void testAddTasks() {
		// arrange
		TaskService service = new TaskService();
		Task task1 = new Task("1", "My Task", "My Description");
		Task task2 = new Task("2", "My Task 2", "My Description 2");
		
		// act
		service.addTask(task1);
		service.addTask(task2);
		
		//assert
		assertTrue(service.getTask("1").equals(task1));
		assertTrue(service.getTask("2").equals(task2));
		assertFalse(service.addTask(task2));
	}
	
	// test removing a task
	@Test
	void testDeleteTask() {
		//arrange
		TaskService service = new TaskService();
		Task task = new Task("1", "My Task", "My Description");
		
		service.addTask(task);
		
		// act
		service.deleteTask(task.id());
		
		// assert
		assertNull(service.getTask(task.id()));
	}
	
	// test updating a task's name/description
	@Test
	void testUpdateFields() {
		// arrange
		TaskService service = new TaskService();
		Task task = new Task("1", "My Task", "My Description");
		service.addTask(task);
		String newValue = "new value";
		
		// act
		service.updateTaskName(task.id(), newValue);
		service.updateTaskDescription(task.id(), newValue);
		
		// assert
		assertTrue(service.getTask(task.id()).name().equals(newValue));
		assertTrue(service.getTask(task.id()).description().equals(newValue));
	}
	
}
