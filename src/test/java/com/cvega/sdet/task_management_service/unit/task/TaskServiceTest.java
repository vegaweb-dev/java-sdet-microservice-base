package com.cvega.sdet.task_management_service.unit.task;

import com.cvega.sdet.task_management_service.task.Task;
import com.cvega.sdet.task_management_service.task.TaskRepository;
import com.cvega.sdet.task_management_service.task.TaskService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void shouldCreateNewTask() {
        //Arrange
        //Act
        //Assert

    }

    @Test
    public void shouldInformTaskAlreadyExists() {
        //Arrange
        //Act
        //Assert

    }

}
