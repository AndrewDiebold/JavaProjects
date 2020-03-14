<!DOCTYPE html>

<%!

public void jspInit() {
    ServletContext application = getServletConfig().getServletContext();
    application.setAttribute("lab36", "This is lab3-6");
}

%>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
      <meta name="generator" content="HTML Tidy, see www.w3.org" />

      <title>Lab 3-6</title>
  </head>

  <body>

      <p><%= application.getAttribute("lab36") %></p>

      <p><a href="/java112">Home</a></p>
  </body>
</html>
