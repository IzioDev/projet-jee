package controllers;

import models.Etudiant;
import models.GestionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class mainController extends HttpServlet {
  // Uri endpoints
  private String indexUri;
  private String studentDetails;
  private String studentEdit;
  private String marksList;
  private String marksEdit;
  private String missingList;
  private String missingEdit;
  private String layout;

  // Logger
  Logger logger = Logger.getLogger(getClass().getName());

  // Init
  public void init() {
    indexUri = getInitParameter("indexUri");
    studentDetails = getInitParameter("studentDetails");
    studentEdit = getInitParameter("studentEdit");
    marksList = getInitParameter("marksList");
    marksEdit = getInitParameter("marksEdit");
    missingList = getInitParameter("missingList");
    missingEdit = getInitParameter("missingEdit");
    layout = getInitParameter("layout");
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

    System.out.println("Action:" + action);

    // Process action
    if (action.equals("/index")) {
      doIndex(request, response);
    } else if (action.equals("/studentDetails")) {
      doStudentDetails(request, response);
    } else if (action.equals("/studentEdit")) {
      doStudentEdit(request, response);
    } else if (action.equals("/marksList")) {
      doMarksList(request, response);
    } else if (action.equals("/marksEdit")) {
      doMarksEdit(request, response);
    } else if (action.equals("/missingList")) {
      doMissingList(request, response);
    } else if (action.equals("/missingEdit")) {
      doMissingEdit(request, response);
    } else {
      throw new ServletException();
    }
  }

  private void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.indexUri, request, response);
  }

  private void doStudentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Etudiant etudiant = GestionFactory.getEtudiantById(Integer.parseInt(request.getParameter("studentId")));

    request.setAttribute("etudiant", etudiant);
    loadJSP(this.studentDetails, request, response);
  }

  private void doStudentEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.studentEdit, request, response);
  }

  private void doMarksList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("etudiants", GestionFactory.getEtudiants());

    loadJSP(this.marksList, request, response);
  }

  private void doMarksEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.marksEdit, request, response);
  }

  private void doMissingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("etudiants", GestionFactory.getEtudiants());

    loadJSP(this.missingList, request, response);
  }

  private void doMissingEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.missingEdit, request, response);
  }

  public void loadJSP(String url, HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

    ServletContext sc = getServletContext();
    request.setAttribute("content", url);
    RequestDispatcher rd = sc.getRequestDispatcher(this.layout);
    rd.forward(request, response);
  }
}
