<%@ page import="model.Author" %><%
    Author author=(Author) request.getSession().getAttribute("CURRENT_USER");
    boolean online=false;
    if(author!=null){
        online=true;
    }
%>