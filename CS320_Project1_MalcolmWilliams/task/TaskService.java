/*
 * Malcolm Williams
 * CS320
 * SNHU
 * 12FEB2024
 */
package task;

import java.util.HashMap;

public class TaskService {

	// task container
	private HashMap<String, Task> tasks;
	
	// constructor
	public TaskService() {
		this.tasks = new HashMap<String, Task>();
	}
	
	// retrieve a task
	public Task getTask(String id) {
		return tasks.get(id);
	}
	
	// add a task to the container
	public boolean addTask(Task newTask) {
		if (tasks.containsKey(newTask.id())) {
			return false;
		}
		
		tasks.put(newTask.id(), newTask);
		return true;
	}
	
	// remove a task from the container
	public boolean deleteTask(String id) {
		return tasks.remove(id) == null ? false: true;
	}
	
	
	// update the name of a task in the container
	public boolean updateTaskName(String id, String value) {
		Task task = getTask(id);
		if (task == null) {
			return false;
		}
		task.setName(value);
		return true;
	}

	// update the description of a task in the container
	public boolean updateTaskDescription(String id, String value) {
		Task task = getTask(id);
		if (task == null) {
			return false;
		}
		task.setDescription(value);
		return true;
	}
	
}
