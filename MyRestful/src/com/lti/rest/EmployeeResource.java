package com.lti.rest;
import javax.ws.rs.*;
@Path("employee")
public class EmployeeResource 
{
	@GET
	@Path("{empno}")
	@Produces("application/json")
	public String getJson(@PathParam("empno")int empno)
{
	switch(empno)
	{
	case 1: return"{'name' : 'John Snow' , 'age' : 22}";
	case 2: return"{'name' : 'Peter Norton' , 'age' : 32}";
	default: return"{'name' : 'Jack of all' , 'age' : 12}";
	}
}
}
