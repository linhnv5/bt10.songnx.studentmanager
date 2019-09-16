package topica.linhnv5.studentmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import topica.linhnv5.studentmanager.model.StudentDB;

@WebServlet(urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = -1490153366869185642L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // get infomation send to server
        int id;

        try {
        	id = Integer.parseInt(request.getParameter("id"));
        } catch(Exception e) {
        	// print 0 to unsuccessful
        	out.println("0");
        	return;
        }

        // add to server
        StudentDB.gI().deleteStudent(id);

        // print 1 to success
    	out.println("1");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
