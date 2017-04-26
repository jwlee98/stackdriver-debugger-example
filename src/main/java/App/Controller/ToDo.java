package App.Controller;

import App.ViewModel.ToDoItem;
import App.ViewModel.ToDoList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class ToDo {

    @RequestMapping(value = "/list/", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ToDoList list(@RequestBody ToDoList list) {
        list.itemList = list.itemList.stream().map(t -> {
            ToDoItem item = new ToDoItem(t.task, t.hours * 2);
            return item;
        }).collect(Collectors.toList());

        return list;
    }

}
