package com.mphasis.training.servlets.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mphasis.training.servlets.DemoServlet;

public class DemoServletTest {
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, ServletException {
		when(request.getParameter("fn")).thenReturn("Shwetha");
		when(request.getParameter("ln")).thenReturn("KashimShetty");
	
		StringWriter writer=new StringWriter();
		PrintWriter out=new PrintWriter(writer);
		when(response.getWriter()).thenReturn(out);
		
		DemoServlet ser=new DemoServlet();
		ser.doGet(request,response);
		
		String expected="FullName: Shwetha KashimShetty";
		String actual=writer.getBuffer().toString();
		assertEquals(expected, actual);
	
	
	}

}
