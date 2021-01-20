package com.zensar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
	 @Autowired
	  List<Employee> employeeList;
	 
	
	  @Autowired
	 Employee employee;
	
	 @Autowired
	 EmployeeService employeeService;
	  
	  @RequestMapping("/")
	    public ModelAndView openIndexPage()
	    {
		  ModelAndView modelAndView = new ModelAndView("index.jsp");
	        return modelAndView;
	    }
	  
	  
	  @RequestMapping("/addEmployee")
	    public ModelAndView addEmployee(Employee employee) {
		  System.out.println("I add()");
		  employeeService.save(employee);
	        ModelAndView mv = new ModelAndView("index.jsp");
	        return mv;
	    }
	  
	  @RequestMapping("/viewAllEmployees")
	    public ModelAndView getAllEmployee() {
		  System.out.println("hello");
		  List<Employee> employee=new ArrayList<Employee>();
		  employee=(List<Employee>) employeeService.findAll();  
		 ModelAndView mv=new ModelAndView("viewAllEmployees.jsp");
		 mv.addObject("employeeInfo", employee);
		 return mv;
	        
	    }
	    
	 
	  /*
	  @RequestMapping("/delete")
	    public ModelAndView deleteEmployee() {
		  System.out.println("I am inside delete()");
		   
			employeerepository.deleteById(employee.getEmployeeid());
	        ModelAndView mv = new ModelAndView("index.jsp");
	       
	        return mv;
	    }
	    */
	  
	  @RequestMapping("/delete")
			public ModelAndView deleteEmployee(@RequestParam("employeeid") Integer employeeid) {
			employeeService.deleteById(employeeid);
			System.out.println("Sucessfully Deleted");
			ModelAndView mv=new ModelAndView("index.jsp");
			return mv;

}	  
	  @RequestMapping("/updateEmployeeForm")
	    public ModelAndView updateForm(@RequestParam("employeeid") Integer employeeid) {
	    System.out.println("Inside updateEmployee !");
	    Employee employee = employeeService.findById(employeeid);
	    ModelAndView modelAndView = new ModelAndView("updateEmployeeForm.jsp");
	    modelAndView.addObject("employee1",employee);
	    return modelAndView;
	    }
	  /*
	  
	  @RequestMapping("/updateEmployee")
	     public ModelAndView update(@RequestParam("employeeid") Integer employeeid, @RequestParam("employeename") String employeename, @RequestParam("designation") String designation,  @RequestParam("salary") Integer salary, @RequestParam("gender") String gender, @RequestParam("city") String city)
	   {
	       System.out.println("I am inside update() method.....");
	 
	      
	     
	       employee.setEmployeeid(employeeid);
	       employee.setEmployeename(employeename);
	       employee.setDesignation(designation);
	       employee.setSalary(salary);
	       employee.setGender(gender);
	       employee.setCity(city);
	     
	       employeerepository.save(employee);
	       System.out.println("Employee record update");
	     
	       ModelAndView modelAndView = new ModelAndView("index.jsp");
	     
	       return modelAndView;
	   }
	   */
	   
	    
	
}