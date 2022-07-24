package ecommerce.controller;

import ecommerce.model.Test;
import ecommerce.service.abs.TestService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    public final TestService testService;

    public TestController(@Qualifier("testServiceImpl") TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    public Test save(@RequestBody Test test){

        return testService.save(test);
    }

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Test> getAllTests(){

        return testService.getAll();
    }

    @RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){

        testService.delete(id);
    }

//    @RequestMapping(value="/update",method = RequestMethod.PUT)
//    public Test updateTestById(@RequestBody Test test){
//        return testService.update(test);
//    }


}
