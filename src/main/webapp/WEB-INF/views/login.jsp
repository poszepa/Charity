<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

  <jsp:include page="static/header.jsp"/>

  <div class="slogan container container--90">
    <div class="slogan--item">
      <h1>
        Zacznij pomagać!<br/>
        Oddaj niechciane rzeczy w zaufane ręce
      </h1>
    </div>
  </div>
  </header>

    <section class="login-page">
      <h2>Zaloguj się</h2>
      <form:form method="post" modelAttribute="user" action="/login">
        <div class="form-group">
          <form:input path="email" type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
          <form:input path="password" type="password" name="password" placeholder="Hasło" />
          <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
          <a href="#" class="btn btn--without-border">Załóż konto</a>      
          <button class="btn" type="submit">Zaloguj się</button> 
        </div>
      </form:form>
    </section>


  <jsp:include page="static/footer.jsp"/>