package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Device;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeviceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Samsung", "Galaxy S24"));
        devices.add(new Device("Apple", "iPhone 16"));

        req.setAttribute("listSize", devices.size());
        req.setAttribute("devicesAttribute", devices);

        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/devices.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");

        if (firstName.isBlank()) {
            req.setAttribute("isFirstNameValid", "false");
        }

        String lastName = req.getParameter("lastName");

        if (lastName.isBlank()) {
            req.setAttribute("isLastNameValid", "false");
        }

        if (!req.getAttributeNames().hasMoreElements()) {
            req.setAttribute("isFormValid", "true");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/create.jsp");
        dispatcher.forward(req, resp);
    }

}
