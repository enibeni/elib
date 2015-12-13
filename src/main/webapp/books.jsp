<%--
  Created by IntelliJ IDEA.
  User: enibeni
  Date: 19.11.15
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devcolibri.com</title>
</head>
<body>
j;k;kj
<%--${fnamelist}--%>
<ul>
    <c:forEach items="${booksList}" var="blist">
        <li> ${blist.title} </li>
    </c:forEach>
</ul>

</body>
</html>