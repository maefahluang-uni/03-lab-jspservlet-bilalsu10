package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet ("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        int num1 = Integer.parseInt(request.getParameter("weight"));
        double num2 = Double.parseDouble(request.getParameter("height"));
        
        //TODO: calculate bmi
        double bmi = num1/(num2*num2);
        Math.round(bmi);
        String bmiResult;

        //TODO: determine the built from BMI
        if(bmi <18.5 ){
            bmiResult = "underweight";
        } else if (bmi < 25 && bmi >= 18.5){
            bmiResult = "normal";
        } else if (bmi < 30 && bmi >=25){
            bmiResult = "overweight";
        } else if ( bmi < 35 && bmi >= 30){
            bmiResult = "obese";
        } else{
            bmiResult = "extremely obese";
        }
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("built", bmi);
        request.setAttribute("bmiResult", bmiResult);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
           
    }
    
}
