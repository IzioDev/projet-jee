package controllers;

import models.Etudiant;
import models.EtudiantDAO;
import models.GestionFactory;
import models.Module;
import models.ModuleDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
  private String moduleList;
  private String moduleEdit;

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
    moduleList = getInitParameter("moduleList");
    moduleEdit = getInitParameter("moduleEdit");

    GestionFactory.open();
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
    switch (action) {
      case "/index":
        doIndex(request, response);
        break;
      case "/studentDetails":
        doStudentDetails(request, response);
        break;
      case "/studentEdit":
        doStudentEdit(request, response);
        break;
      case "/marksList":
        doMarksList(request, response);
        break;
      case "/marksEdit":
        doMarksEdit(request, response);
        break;
      case "/missingList":
        doMissingList(request, response);
        break;
      case "/missingEdit":
        doMissingEdit(request, response);
        break;
      case "/moduleList":
        doModuleList(request, response);
        break;
      case "/moduleEdit":
        doModuleEdit(request, response);
        break;
      case "/moduleDelete":
        doModuleDelete(request, response);
        break;
      default:
        throw new ServletException();
    }
  }

  private void doModuleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String stringId = request.getParameter("id");
    Integer id = Integer.valueOf(stringId);

    ModuleDAO.remove(id);
    response.sendRedirect(request.getContextPath() + "/do/moduleList");
  }


  private void doModuleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String stringId = request.getParameter("id");

    String moduleNameParameter = request.getParameter("name");

    // String moduleCoeffParameter = request.getParameter("coeff");
    // && moduleCoeffParameter != null

    if (moduleNameParameter != null) {
      ModuleDAO.create(moduleNameParameter);

      response.sendRedirect(request.getContextPath() + "/do/moduleList");
      return;
    }

    if ( stringId != null) {
      request.setAttribute("isCreation", Boolean.FALSE);
    } else {
      request.setAttribute("isCreation", Boolean.TRUE);
      loadJSP(this.moduleEdit, request, response);
    }
  }

  private void doModuleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Module> modules = ModuleDAO.getAll();

    request.setAttribute("modules", modules);
    loadJSP(this.moduleList, request, response);
  }

  private void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.indexUri, request, response);
  }

  private void doStudentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer etudiantId = Integer.parseInt(request.getParameter("studentId"));
    Etudiant etudiant = EtudiantDAO.retrieveById(etudiantId);

    request.setAttribute("etudiant", etudiant);
    loadJSP(this.studentDetails, request, response);
  }

  private void doStudentEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.studentEdit, request, response);
  }

  private void doMarksList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setAttribute("etudiants", EtudiantDAO.getAll());

    loadJSP(this.marksList, request, response);
  }

  private void doMarksEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    loadJSP(this.marksEdit, request, response);
  }

  private void doMissingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("etudiants", EtudiantDAO.getAll());

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

  @Override
  public void destroy() {
    super.destroy();

    // Fermeture de la factory
    GestionFactory.close();
  }
}
