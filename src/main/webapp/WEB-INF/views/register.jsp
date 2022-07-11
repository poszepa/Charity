<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="pl">--%>
<%--  <head>--%>
<%--    <meta charset="UTF-8" />--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0" />--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge" />--%>
<%--    <title>Document</title>--%>
<%--    <link rel="stylesheet" href="css/style.css" />--%>
<%--  </head>--%>
<%--  <body>--%>
<%--    <header>--%>
<%--      <nav class="container container--70">--%>
<%--        <ul class="nav--actions">--%>
<%--          <li><a href="#">Zaloguj</a></li>--%>
<%--          <li class="highlighted"><a href="#">Załóż konto</a></li>--%>
<%--        </ul>--%>

<%--        <ul>--%>
<%--          <li><a href="index.jsp" class="btn btn--without-border active">Start</a></li>--%>
<%--          <li><a href="index.jsp#steps" class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--          <li><a href="index.jsp#about-us" class="btn btn--without-border">O nas</a></li>--%>
<%--          <li><a href="index.jsp#help" class="btn btn--without-border">Fundacje i organizacje</a></li>--%>
<%--          <li><a href="index.jsp#contact" class="btn btn--without-border">Kontakt</a></li>--%>
<%--        </ul>--%>
<%--      </nav>--%>
<%--    </header>--%>
<jsp:include page="static/header.jsp"/>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form modelAttribute="user" method="post" action="/register">
        <div class="form-group">
          <form:input path="email" type="email" name="email" placeholder="Email" />
          <form:errors path="email"/>
        </div>
        <div class="form-group">
          <form:input path="password" type="password" name="password" placeholder="Hasło" />
          <form:errors path="email"/>
        </div>
        <div class="form-group">
          <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
          <a href="login.jsp" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>>
    </section>


  <jsp:include page="static/footer.jsp"/>
