<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Website short description." />
    <meta name="keywords" content="website main keywords" />
    <title>
      My First JSP
    </title>
    <link href="style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div id="container">
      <div id="header">
        <h1>
          Advanced Java 112
        </h1>
      </div>
      <div id="sub_header">
        Andrew Diebold
      </div>
      <div id="main_content_top"></div>
      <div id="main_content">
        <div class="content">

            <h1>My First JSP</h1>
            <img src="images/java.jpg">


        </div>
        <div class="menu">
          <div class="menu_title">Unit 2</div>
            <ul>
                <li>
                    <a href="/java112/trivial">Trivial Servlet</a>
                </li>
                <li>
                    <a href="linkingDemo.html">Linking Demo</a>
                </li>
                <li>
                    <a href="/java112/LabFive">Lab 5</a>
                </li>
            </ul>

          <div class="menu_title">Unit 3</div>

          <ul>
              <li>
                  <a href="myFirstJSP.jsp">My First JSP</a>
              </li>

          </ul>

          <div class="menu_title">Unit 4</div>



        </div>
        <div id="clear"></div>
      </div>
      <div id="main_content_bottom"></div>
      <div id="footer">
        <strong>Copyright © 2019</strong> | <b>Design by</b>
        <a href="http://www.andrewdiebold.com">andrewdiebold.com</a>
      </div>
    </div>
    <%= new java.util.Date() %>
  </body>
</html>
