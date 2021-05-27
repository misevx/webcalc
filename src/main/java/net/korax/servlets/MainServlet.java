package net.korax.servlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet(name="main", urlPatterns={"/", "/main", "/calc"})
public class MainServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");


		String operand1  = request.getParameter("x");
		String operand2  = request.getParameter("y");
		String operation = request.getParameter("op");

		if(operand1 == null || operand1 == null || operation == null ) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		int op1 = Integer.parseInt(operand1);
		int op2 = Integer.parseInt(operand2);
		int result = 0;

		switch(operation) {
			case "add": result = op1 + op2;	break;
			case "sub": result = op1 - op2;	break;
			case "mul": result = op1 * op2;	break;
			case "div": result = op1 / op2;	break;
			case "mod": result = op1 / op2;	break;
		}

		pw.println("Result is " + result);
	}
}
