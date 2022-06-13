package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/gallery")
public class GalleryServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    File folder = new File("/home/dsmith/software-product-sprint/portfolio/src/main/webapp/images/gallery");
    File[] listOfFiles = folder.listFiles();
    ArrayList<String> fileNames = new ArrayList<>();
    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
           fileNames.add(listOfFiles[i].getName());
        }
    }
    String json = convertToJsonUsingGson(fileNames);
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(Object obj) {
    Gson gson = new Gson();
    String json = gson.toJson(obj);
    return json;
  }
}