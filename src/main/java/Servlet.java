

import java.io.IOException;
import java.io.PrintWriter;

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
				
		PrintWriter out = response.getWriter();
		String tipo = request.getParameter("conversao");
		String valor = request.getParameter("valor");
		String fraseResult = null;
		double resultado = 0;
	
		if(tipo.equalsIgnoreCase("celsius")) {
			resultado = CelsiusToFahrenheit(valor);
			fraseResult ="A conversão de "+ valor +" graus Celsius para Fahrenheit é de: " + resultado;	
		}
		else {
			resultado = FahrenheitToCelsius(valor);
			fraseResult ="A conversão de "+ valor +" graus Fahrenheit para Celsius é de: " + resultado;
		}
		
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" href=\"style.css\">");
		out.print("<title>Resultado da Conversão</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>" + fraseResult + "</h1>");
		out.print("</body>");
		out.print("</html>");
	}
	
	private double CelsiusToFahrenheit(String valor) {
		return ((Double.valueOf(valor) * 9) / 5) + 32;
	}
	
	private double FahrenheitToCelsius(String valor) {	
		return ((Double.valueOf(valor) - 32) * 5) / 9;
	}
}
