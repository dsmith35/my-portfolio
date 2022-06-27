package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/emoji")
public class EmojiServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    String[] emojiList = {"0x1F600", "0x1F606","0x1F607","0x1F634","0x1F973","0x1F61C","0x1F60E","0x1F929"};
    String json = convertToJsonUsingGson(emojiList);
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(Object obj) {
    Gson gson = new Gson();
    String json = gson.toJson(obj);
    return json;
  }
}