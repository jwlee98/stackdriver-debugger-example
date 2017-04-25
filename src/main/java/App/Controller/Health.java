package App.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/health")
public class Health {

    @RequestMapping(method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void index() { }
}
