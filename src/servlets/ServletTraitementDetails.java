package servlets;

import models.Etudiant;
import models.GestionFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlettraitementdetails")
public class ServletTraitementDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Etudiant etudiant = GestionFactory.getEtudiantById(Integer.parseInt(request.getParameter("etudiantId")));
        int missingNumber = GestionFactory.getAbsencesByEtudiantId(Integer.parseInt(request.getParameter("etudiantId")));
        etudiant.setNbAbsence(missingNumber);

        request.setAttribute("etudiant", etudiant);

        getServletContext().getRequestDispatcher("/student_details.jsp").forward(request, response);
    }
}
