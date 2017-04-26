package App.Controller;

import App.ViewModel.ToDoItem;
import App.ViewModel.ToDoList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ToDo.class)
public class ToDoTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ToDoShouldDoubleHours() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ToDoList toDoList = new ToDoList();
        toDoList.itemList = new ArrayList<>(Arrays.asList(
                new ToDoItem("task 1", 1),
                new ToDoItem("task 2", 2),
                new ToDoItem("task 3", 3)
        ));

        ToDoList expectedList = new ToDoList();
        expectedList.itemList = new ArrayList<>(Arrays.asList(
                new ToDoItem("task 1", 2),
                new ToDoItem("task 2", 4),
                new ToDoItem("task 3", 6)
                ));

        System.out.println(mapper.writeValueAsString(toDoList));

        this.mockMvc.perform(post("/todo/list/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(toDoList)))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedList)));
    }
}
