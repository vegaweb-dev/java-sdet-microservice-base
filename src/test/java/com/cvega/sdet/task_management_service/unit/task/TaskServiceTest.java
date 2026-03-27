package com.cvega.sdet.task_management_service.unit.task;

import com.cvega.sdet.task_management_service.task.Task;
import com.cvega.sdet.task_management_service.task.TaskRepository;
import com.cvega.sdet.task_management_service.task.TaskService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    @Test
    public void shouldReturnListOfTasks() {
        //Arrange
        TaskRepository repositoryMock = mock(TaskRepository.class);
        TaskService taskService = new TaskService(repositoryMock);
        List<Task> fakeList = List.of();
        when(repositoryMock.findAll()).thenReturn(fakeList);

        //Act
        List<Task> tasks = taskService.listGenerator();
        //Assert
        assertEquals(fakeList, tasks);
        verify(repositoryMock).findAll();
    }

    @Test
    public void shouldSaveNewTaskWhenDescriptionDoesNotExist() {
        //Arrange
        TaskRepository repositoryMock = mock(TaskRepository.class);
        TaskService taskService = new TaskService(repositoryMock);
        Task task = new Task();
        task.setTaskDescription("this is the description of new task to be saved");
        when(repositoryMock.findByTaskDescription(task.getTaskDescription())).thenReturn(Optional.empty());
        //Act
        taskService.createNewTask(task);
        //Assert
        verify(repositoryMock, times(1)).save(task);
    }

    @Test
    public void shouldInformTaskAlreadyExists() {
        //Arrange
        TaskRepository repositoryMock = mock(TaskRepository.class);
        TaskService taskService = new TaskService(repositoryMock);
        Task task = new Task();
        task.setTaskDescription("this is the new existing task");
        when(repositoryMock.findByTaskDescription(task.getTaskDescription())).thenReturn(Optional.of(task));
        //Act + Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> taskService.createNewTask(task));
        assertEquals("This task is already registered", exception.getMessage());
        verify(repositoryMock, never()).save(task);
    }
}
