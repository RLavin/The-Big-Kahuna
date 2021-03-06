package com.ironyard.servlet;

import com.ironyard.services.BudgetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Raul on 10/3/16.
 */
public class SearchBudgetServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the movies
        BudgetService  ms = new BudgetService();
        String destination = "/budgetlist";
        try {
            // get the search text
            String searchByText = req.getParameter("searchtext");

            req.setAttribute("thebudgetlist", ms.Search(searchByText ));
        } catch (SQLException e) {
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to proper JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);    }
}
