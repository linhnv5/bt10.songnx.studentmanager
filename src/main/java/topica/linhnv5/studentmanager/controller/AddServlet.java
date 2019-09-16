package topica.linhnv5.studentmanager.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import topica.linhnv5.studentmanager.model.StudentDB;
import topica.linhnv5.studentmanager.utils.DateUtil;

@WebServlet(urlPatterns = { "/add" })
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 334707803470915025L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // get infomation send to server
        String name; byte gender; Date admissionDay;

        try {
        	name         = request.getParameter("name");
        	gender       = Byte.parseByte(request.getParameter("gender"));
        	admissionDay = DateUtil.gI().parse(request.getParameter("admissionDay"));
        } catch(Exception e) {
        	// print 0 to unsuccessful
        	out.println("0");
        	return;
        }

        // add to server
        StudentDB.gI().addStudent(name, gender, admissionDay);

        // print 1 to success
    	out.println("1");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
