package csi403;


// Import required java libraries

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;




// Extend HttpServlet class
public class DiscernJsonService extends HttpServlet {

  // Standard servlet method 
    public void init() throws ServletException { 
        // Do any required initialization here - likely none
    }
    
    // Standard servlet method - we will handle a POST operation
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        doService(request, response); 
    }

    // Standard Servlet method
    public void destroy() { 
        // Do any required tear-down here, likely nothing.
    }

    // Standard servlet method - we will not respond to GET
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        // Set response content type and return an error message
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // We can always create JSON by hand just concating a string.  
        out.println("{ 'message' : 'Use POST!'}");
    }
    
    // Our main worker method
    private void doService(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        // Get received JSON data from HTTP request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = "";
        if(br != null){
            jsonStr = br.readLine();
        }

        //String incomeList = new JsonClassDiscerner().discern(jsonStr);
        //LinkedList<SubInJSON> incomeList = new JsonClassDiscerner().discern(jsonStr);

        //JsonSerializer serializer = new JsonSerializer();

        //OutJSON outJSON = new OutJSON();

        //outJSON.setOutList();


        String outMessage = new JsonClassDiscerner().discern(jsonStr);

        // Set response content type to be JSON
        response.setContentType("application/json");
        // Send back the name of the class as a JSON message
        PrintWriter out = response.getWriter();
        out.println(outMessage);
    }
    
    
}

