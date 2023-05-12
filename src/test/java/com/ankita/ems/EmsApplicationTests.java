package com.ankita.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ankita.ems.exception.RecordNotFoundException;
import com.ankita.ems.model.Employee;
import com.ankita.ems.repository.EmployeeRepository;
import com.ankita.ems.service.EmployeeService;

@ExtendWith(SpringExtension.class)
class EmsApplicationTests {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	void givenEmployeesGetListOfAllEmployees() {
		when(employeeRepository.findAll())
				.thenReturn(Collections.singletonList(new Employee(1, "test", "test@email.com", "123", "test")));
		List<Employee> list = employeeService.getAllEmployees();
		System.out.println(list);
		assertThatList(list).isNotEmpty();
		assertThatList(list).hasSize(1);
		assertThatList(list).doesNotContainNull();
		assertThatList(list).matches(e -> e.get(0).getName().equalsIgnoreCase("test"));
	}

	@Test
	void whenNoRecordThrowException() throws RecordNotFoundException {
		Integer testId = 0;
		when(employeeRepository.findById(anyInt())).thenReturn(Optional.empty());
		Exception exception = assertThrows(RecordNotFoundException.class,
				() -> employeeService.getEmployeeByID(testId));
		assertThat(exception.getMessage()).contains(testId.toString());
	}

}
