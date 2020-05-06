package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HospitalAPI
 */
@WebServlet("/HospitalAPI")
public class HospitalAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Hospital_DB hos_Obj = new Hospital_DB();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = hos_Obj.insertHospital(request.getParameter("hos_name"),
				 request.getParameter("hos_address"),
			 	 request.getParameter("hos_phone"),
			 	 request.getParameter("hos_email"));
		
				response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		 String output = hos_Obj.updateHospital(paras.get("hidItemIDSave").toString(),
		 paras.get("hos_name").toString(),
		 paras.get("hos_address").toString(),
		paras.get("hos_phone").toString(),
		paras.get("hos_email").toString());
		response.getWriter().write(output);
		}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			 Map paras = getParasMap(request);
			 String output = hos_Obj.deleteHospital(paras.get("hos_id").toString());
			response.getWriter().write(output);
			}


	
	
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
			 for (String param : params)
			 {
				 String[] p = param.split("=");
				 map.put(p[0], p[1]);
			}
		 }
		catch (Exception e)
		 {
		 }
		return map;
		}
		 
		 

		 
	 
}
