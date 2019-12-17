package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class mainController extends HttpServlet {
  // Uri endpoints
  private String indexUri;

  // Constants

  // Init
  public void init() {
    indexUri = getInitParameter("indexUri");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
    // on passe la main au GET
    doGet(request, response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {

    String method = request.getMethod().toLowerCase();
    String action = request.getPathInfo();

    if (action == null) {
      action = "/index";
    }

    // Process action
    if (action.equals("/index")) {
      doIndex(request, response);
    } else {
      throw new ServletException();
    }
  }

  private void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.indexUri, request, response);
  }

  public void loadJSP(String url, HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

    ServletContext sc = getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher(url);
    rd.forward(request, response);
  }
}
