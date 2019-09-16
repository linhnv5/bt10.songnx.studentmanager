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

@WebServlet(urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = -3035054247115638630L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // get infomation send to server
        int id; String name; byte gender; Date admissionDay;

        try {
        	id           = Integer.parseInt(request.getParameter("id"));
        	name         = request.getParameter("name");
        	gender       = Byte.parseByte(request.getParameter("gender"));
        	admissionDay = DateUtil.gI().parse(request.getParameter("admissionDay"));
        } catch(Exception e) {
        	// print 0 to unsuccessful
        	out.println("0");
        	return;
        }

        // add to server
        if(!StudentDB.gI().editStudent(id, name, gender, admissionDay)) {
        	// print 0 to unsuccessful
        	out.println("0");
        	return;
        }

        // print 1 to success
    	out.println("1");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
