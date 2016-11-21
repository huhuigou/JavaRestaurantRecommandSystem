package api;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.MySQLDBConnection;

/**
 * Servlet implementation class Recommandation
 */
@WebServlet("/recommendation")
public class Recommandation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DBConnection connection = new MySQLDBConnection();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recommandation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		JSONArray array = null;
		
		if (request.getParameterMap().containsKey("user_id")) {
			String userId = request.getParameter("user_id");
			array = connection.recommendRestaurants(userId);
		}
		RpcParser.writeOutput(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
