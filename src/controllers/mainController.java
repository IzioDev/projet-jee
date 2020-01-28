package controllers;

import models.*;
import models.Module;

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
  private String studentEdit;
  private String studentList;
  private String marksList;
  private String marksEdit;
  private String missingList;
  private String missingEdit;
  private String layout;
  private String moduleList;
  private String moduleEdit;
  private String groupEdit;

  // Logger
  Logger logger = Logger.getLogger(getClass().getName());


  // Init
  public void init() {
    indexUri = getInitParameter("indexUri");
    studentEdit = getInitParameter("studentEdit");
    studentList = getInitParameter("studentList");
    marksList = getInitParameter("marksList");
    marksEdit = getInitParameter("marksEdit");
    missingList = getInitParameter("missingList");
    missingEdit = getInitParameter("missingEdit");
    layout = getInitParameter("layout");
    moduleList = getInitParameter("moduleList");
    moduleEdit = getInitParameter("moduleEdit");
    groupEdit = getInitParameter("groupEdit");

    try {
      GestionFactory.open();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
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

    request.setCharacterEncoding("UTF-8");

    if (action == null) {
      action = "/index";
    }

    System.out.println("Action:" + action);

    // Process action
    switch (action) {
      case "/index":
        doIndex(request, response);
        break;
      case "/studentList":
        doStudentList(request, response);
        break;
      case "/studentEdit":
        doStudentEdit(request, response);
        break;
      case "/studentDelete":
        doStudentDelete(request, response);
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
      case "/groupEdit":
        doGroupEdit(request, response);
        break;
      case "/groupDelete":
        doGroupDelete(request, response);
        break;
      default:
        throw new ServletException();
    }
  }

  private void doStudentDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String stringId = request.getParameter("id");
    Integer id = Integer.valueOf(stringId);

    Integer groupId = EtudiantDAO.retrieveById(id).getGroupe().getId();
    EtudiantDAO.remove(id);
    response.sendRedirect(request.getContextPath() + "/do/studentList?id=" + groupId);
  }

  private void doStudentEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String studentFirstnameParameter = request.getParameter("firstname");
    String studentLastnameParameter = request.getParameter("lastname");
    String studentIdParameter = request.getParameter("id");
    String studentGroupIdParameter = request.getParameter("groupId");
    String studentNbAbscence = request.getParameter("nbAbscence");

    // It's a form submit
    if (studentFirstnameParameter != null && studentLastnameParameter != null && studentGroupIdParameter != null && studentNbAbscence != null) {
      // It's a form edit
      if (studentIdParameter != null) {
        Integer studentId = Integer.valueOf(studentIdParameter);
        Integer groupId = Integer.valueOf(studentGroupIdParameter);
        Integer nbAbscence = Integer.valueOf(studentNbAbscence);

        Etudiant etudiant = EtudiantDAO.retrieveById(studentId);
        etudiant.setPrenom(studentFirstnameParameter);
        etudiant.setNom(studentLastnameParameter);
        etudiant.setGroupe(GroupeDAO.retrieveById(groupId));
        etudiant.setNbAbsences(nbAbscence);

        EtudiantDAO.update(etudiant);
      } else {
        Integer groupId = Integer.valueOf(studentGroupIdParameter);
        Integer nbAbscence = Integer.valueOf(studentNbAbscence);

        Etudiant etudiant = EtudiantDAO.create(studentFirstnameParameter, studentLastnameParameter, GroupeDAO.retrieveById(groupId));
        etudiant.setNbAbsences(nbAbscence);

        EtudiantDAO.update(etudiant);
      }

      response.sendRedirect(request.getContextPath() + "/do/studentList?id=" + studentGroupIdParameter);
      return;
    }

    if (studentIdParameter != null) {
      Integer id = Integer.valueOf(studentIdParameter);
      request.setAttribute("isCreation", Boolean.FALSE);
      request.setAttribute("student", EtudiantDAO.retrieveById(id));
    } else {
      request.setAttribute("isCreation", Boolean.TRUE);
    }

    request.setAttribute("groups", GroupeDAO.getAll());

    loadJSP(this.studentEdit, request, response);
  }

  private void doGroupEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String groupNameParameter = request.getParameter("name");
    String groupIdParameter = request.getParameter("id");

    // It's a form submit
    if (groupNameParameter != null) {
      // It's a form edit
      if (groupIdParameter != null) {
        Integer groupId = Integer.valueOf(groupIdParameter);
        Groupe group = GroupeDAO.retrieveById(groupId);
        group.setNom(groupNameParameter);
        GroupeDAO.update(group);
      } else {
        GroupeDAO.create(groupNameParameter);
      }

      response.sendRedirect(request.getContextPath() + "/do/index");
      return;
    }

    if ( groupIdParameter != null) {
      Integer id = Integer.valueOf(groupIdParameter);
      request.setAttribute("isCreation", Boolean.FALSE);
      request.setAttribute("group", GroupeDAO.retrieveById(id));
    } else {
      request.setAttribute("isCreation", Boolean.TRUE);
      request.setAttribute("group", null);
    }

    loadJSP(this.groupEdit, request, response);
  }

  private void doGroupDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String stringId = request.getParameter("id");
    Integer id = Integer.valueOf(stringId);

    GroupeDAO.remove(id);
    response.sendRedirect(request.getContextPath() + "/do/index");
  }

  private void doModuleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String stringId = request.getParameter("id");
    Integer id = Integer.valueOf(stringId);

    ModuleDAO.remove(id);
    response.sendRedirect(request.getContextPath() + "/do/moduleList");
  }

  private void doModuleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String moduleNameParameter = request.getParameter("name");
    String moduleIdParameter = request.getParameter("id");

    // It's a form submit
    if (moduleNameParameter != null) {
      // It's a form edit
      if (moduleIdParameter != null) {
        Integer moduleId = Integer.valueOf(moduleIdParameter);
        Module module = ModuleDAO.retrieveById(moduleId);

        module.setNom(moduleNameParameter);
        ModuleDAO.update(module);
      } else {
        ModuleDAO.create(moduleNameParameter);
      }

      response.sendRedirect(request.getContextPath() + "/do/moduleList");
      return;
    }

    if ( moduleIdParameter != null) {
      Integer id = Integer.valueOf(moduleIdParameter);
      request.setAttribute("isCreation", Boolean.FALSE);
      request.setAttribute("module", ModuleDAO.retrieveById(id));
    } else {
      request.setAttribute("isCreation", Boolean.TRUE);
      request.setAttribute("module", null);
    }

    loadJSP(this.moduleEdit, request, response);
  }

  private void doModuleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Module> modules = ModuleDAO.getAll();

    request.setAttribute("modules", modules);
    loadJSP(this.moduleList, request, response);
  }

  private void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("groups", GroupeDAO.getAll());

    loadJSP(this.indexUri, request, response);
  }

  private void doStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer groupId = Integer.parseInt(request.getParameter("id"));
    Groupe group = GroupeDAO.retrieveById(groupId);

    request.setAttribute("group", group);
    loadJSP(this.studentList, request, response);
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
