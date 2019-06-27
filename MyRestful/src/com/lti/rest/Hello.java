package com.lti.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Hello {

	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello()
{
		return "Hello Jersey Plain";
}
	@GET
	@Path("/xmlhello")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello()
	{
		return "<?xml version=\"1.0\"?>"+"<hello> Hello Jersey"+"</hello>";
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
public String sayHTMLHello()
{
		return "<HTML>"+"<TITLE>"+"Hello Jersey"+"</TITLE>"+"<BODY><H1>"+"Hello Jersey HTML"+"</H1></BODY>"+"</HTML>";
}
}