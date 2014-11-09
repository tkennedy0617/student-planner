package edu.ecu.seng6240.team6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;

import edu.ecu.seng6240.team6.Helper.RequestHelper;
import edu.ecu.seng6240.team6.Helper.UserDataManager;
import edu.ecu.seng6240.team6.models.Student;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if (action == null) return;
		int responseCode = Response.SC_OK;		
		if (action.equals("add")){
			Student student = null;
			String dataString = RequestHelper.getDataString(request);
			if (dataString != null) {
				student = new Gson().fromJson(dataString, Student.class);
				boolean insertSuccess = UserDataManager.insert(student);
				if (!insertSuccess) {
					responseCode = Response.SC_BAD_REQUEST;
				}				
			} else {
				responseCode = Response.SC_BAD_REQUEST;
			}			
		}
		else if (action.equals("update")){
			Student student = null;
			String dataString = RequestHelper.getDataString(request);
			if (dataString != null) {
				student = new Gson().fromJson(dataString, Student.class);
				boolean updateSuccess = UserDataManager.update(student);
			} else {

			}						
		}
		else if (action.equals("delete")){
			String idString = request.getParameter("id");
			int id = Integer.parseInt(idString);
			boolean deleteSuccess = UserDataManager.deleteStudent(id);
			if (deleteSuccess) {
				
			}
		}
		else {
			responseCode = Response.SC_BAD_REQUEST;
		}
		response.setStatus(responseCode);
	}

}
