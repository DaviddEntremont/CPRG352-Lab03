package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     //Set the result variable to "---" first thing 
        request.setAttribute("result", "---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculatorForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // capture the first and second number parameter
        String firstnumber = request.getParameter("firstNumber");
        
        String secondnumber = request.getParameter("secondNumber");
        
    
        //save entrys to the form
        request.setAttribute("first_number", firstnumber);
        
        request.setAttribute("second_number", secondnumber);
        
        
        //create variables before parsing
        int firstInt;
        
        int secondInt;
 
        
        // test input to see if it's null or empty string
        if( firstnumber == null || firstnumber.equals("") || secondnumber == null || secondnumber.equals("")){
            
            request.setAttribute("result", "invalid");

            getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculatorForm.jsp").forward(request, response);
            
            return;
        }
        
        // change inputs to an int and test to see if the input was a number
        try {
            firstInt = Integer.parseInt(firstnumber);
            
            secondInt = Integer.parseInt(secondnumber);
        }
        catch (NumberFormatException nfe) {
            
            request.setAttribute("result", "invalid");

            getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculatorForm.jsp").forward(request, response);

            return;
        }
        
        //get what type of equation is being request through the buttons and create result variable
        String equationType = request.getParameter("equation");
        
        int result;
        
        //find out what button was entered and then use it to calculate the result
        if (equationType.equals("+")) {
            result = firstInt + secondInt;
        }
        else if (equationType.equals("-")) {
            result = firstInt - secondInt;
        }
        else if (equationType.equals("*")) {
            result = firstInt * secondInt;
        }
        else {
            result = firstInt%secondInt;
        }
        
        //return the result
        
        request.setAttribute("result", result);
        
        System.out.println(equationType);
                
       getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculatorForm.jsp").forward(request, response);
       return;
       
    }


}
