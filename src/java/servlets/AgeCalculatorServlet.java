package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalulatorForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // capture the ageinput parameter
        String ageInput = request.getParameter("ageinput");
        
        // save entry to the form and create a variable if the input works
        request.setAttribute("age_input", ageInput);
        
        int ageInputInt;
        
        // test input to see if it's null or empty string
        if( ageInput == null || ageInput.equals("")){
            request.setAttribute("nullEntry", true);

            getServletContext().getRequestDispatcher("/WEB-INF/AgeCalulatorForm.jsp").forward(request, response);
            
            return;
        }
        
        // change input to an int and test to see if the input was a number
        try {
            ageInputInt = Integer.parseInt(ageInput);
        }
        catch (NumberFormatException nfe) {
            
            request.setAttribute("nonNumeric", true);

            getServletContext().getRequestDispatcher("/WEB-INF/AgeCalulatorForm.jsp").forward(request, response);

            return;
        }
        
        // increment the age, send that number back
        ageInputInt++;
        
        request.setAttribute("allGood", true);
        
        request.setAttribute("newAge", ageInputInt);
        
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalulatorForm.jsp").forward(request, response);
        return;
    }
}
