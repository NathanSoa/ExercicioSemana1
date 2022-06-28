

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("conversao");
		String valor = request.getParameter("valor");
		double resultado = 0;
		
		if(tipo.equalsIgnoreCase("celsius"))
			resultado = CelsiusToFahrenheit(valor);
		else
			resultado = FahrenheitToCelsius(valor);
		
		System.out.println(resultado);
	}
	
	private double CelsiusToFahrenheit(String valor) {
		return ((Double.valueOf(valor) * 9) / 5) + 32;
	}
	
	private double FahrenheitToCelsius(String valor) {	
		return ((Double.valueOf(valor) - 32) * 5) / 9;
	}
}
