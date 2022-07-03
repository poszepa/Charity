<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="static/header.jsp"/>
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
<%--    <header class="header--form-page">--%>
<%--      <nav class="container container--70">--%>
<%--        <ul class="nav--actions">--%>
<%--          <li class="logged-user">--%>
<%--            Witaj Agata--%>
<%--            <ul class="dropdown">--%>
<%--              <li><a href="#">Profil</a></li>--%>
<%--              <li><a href="#">Moje zbiórki</a></li>--%>
<%--              <li><a href="#">Wyloguj</a></li>--%>
<%--            </ul>--%>
<%--          </li>--%>
<%--        </ul>--%>

<%--        <ul>--%>
<%--          <li><a href="index.jsp" class="btn btn--without-border active">Start</a></li>--%>
<%--          <li><a href="index.jsp#steps" class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--          <li><a href="index.jsp#about-us" class="btn btn--without-border">O nas</a></li>--%>
<%--          <li><a href="index.jsp#help" class="btn btn--without-border">Fundacje i organizacje</a></li>--%>
<%--          <li><a href="index.jsp#contact" class="btn btn--without-border">Kontakt</a></li>--%>
<%--        </ul>--%>
<%--      </nav>--%>

<%--      <div class="slogan container container--90">--%>
<%--        <div class="slogan--item">--%>
<%--          <h1>--%>
<%--            Oddaj rzeczy, których już nie chcesz<br />--%>
<%--            <span class="uppercase">potrzebującym</span>--%>
<%--          </h1>--%>

<%--          <div class="slogan--steps">--%>
<%--            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>--%>
<%--            <ul class="slogan--steps-boxes">--%>
<%--              <li>--%>
<%--                <div><em>1</em><span>Wybierz rzeczy</span></div>--%>
<%--              </li>--%>
<%--              <li>--%>
<%--                <div><em>2</em><span>Spakuj je w worki</span></div>--%>
<%--              </li>--%>
<%--              <li>--%>
<%--                <div><em>3</em><span>Wybierz fundację</span></div>--%>
<%--              </li>--%>
<%--              <li>--%>
<%--                <div><em>4</em><span>Zamów kuriera</span></div>--%>
<%--              </li>--%>
<%--            </ul>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </header>--%>

    <section class="form--steps">
      <div class="form--steps-instructions">
        <div class="form--steps-container">
          <h3>Ważne!</h3>
          <p data-step="1" class="active">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="2">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="3">
           Wybierz jedną, do
            której trafi Twoja przesyłka.
          </p>
          <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
      </div>

      <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="donation" method="post" modelAttribute="donation">
          <!-- STEP 1: class .active is switching steps -->
          <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>
            <div class="itemToGive">
<c:forEach items="${listOfCategory}" var="category">
              <div class="form-group form-group--checkbox">
                <label>
                  <input type="hidden" value="${category.name}" class="descriptionName">
                  <input
                    class="categoryForm"
                    type="checkbox"
                    name="categories"
                    value="${category.id}"
                  />
                  <span class="checkbox"></span>
                  <span class="description"
                    >${category.name}</span
                  >
                </label>
              </div>
</c:forEach>
              <div class="form-group form-group--buttons">
                <button type="button" class="btn next-step">Dalej</button>
              </div>
            </div>
          </div>

          <!-- STEP 2 -->
          <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

            <div class="form-group form-group--inline">
              <label>
                Liczba 60l worków:
                <form:input path="quantity" id="quantity" step="1" min="1"/>
                <form:errors path="quantity"/>
              </label>
            </div>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>



          <!-- STEP 3 -->
          <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <c:forEach items="${listOfInstitution}" var="institution">
            <div class="form-group form-group--checkbox">
              <label>
                <input type="hidden" name="institutionName" value="${institution.name}" id="institutionName${institution.id}">
                <input type="radio" name="institution" value="${institution.id}" />
                <span class="checkbox radio"></span>
                <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">
                      ${institution.description}
                  </div>
                </span>
              </label>
            </div>
            </c:forEach>


            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>

          <!-- STEP 4 -->
          <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
              <div class="form-section--column">
                <h4>Adres odbioru</h4>
                <div class="form-group form-group--inline">
                  <label> Ulica <form:input path="street" id="street"/> </label>
                  <form:errors path="street"/>
                </div>

                <div class="form-group form-group--inline">
                  <label> Miasto <form:input path="city" id="city"/> </label>
                  <form:errors path="city"/>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Kod pocztowy  <form:input path="zipCode"/>
                    <form:errors path="zipCode"/>
                  </label>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Numer telefonu <form:input path="phoneNumber" id="phoneNumber"/>
                    <form:errors path="phoneNumber"/>
                  </label>
                </div>
              </div>

              <div class="form-section--column">
                <h4>Termin odbioru</h4>
                <div class="form-group form-group--inline">
                  <label> Data <form:input path="pickUpDate" type="date" id="date"/> </label>
                  <form:errors path="pickUpDate"/>
                </div>

                <div class="form-group form-group--inline">
                  <label> Godzina <form:input path="pickUpTime" type="time" id="time"/> </label>
                  <form:errors path="pickUpTime"/>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Uwagi dla kuriera
                    <form:textarea path="pickUpComment" id="pickUpComment"/>
                    <form:errors path="pickUpComment"/>
                  </label>
                </div>
              </div>
            </div>
            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>

          <!-- STEP 5 -->
          <div data-step="5">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary">
              <div class="form-section">
                <h4>Oddajesz:</h4>
                <ul>
                  <li>
                    <span class="icon icon-bag"></span>
                    <span class="summary--text qunatity-things"
                      >4 worki ubrań w dobrym stanie dla dzieci</span
                    >
                  </li>

                  <li>
                    <span class="icon icon-hand"></span>
                    <span class="summary--text institutitonDonation"
                      >Dla fundacji "Mam marzenie" w Warszawie</span
                    >
                  </li>
                </ul>
              </div>

              <div class="form-section form-section--columns">
                <div class="form-section--column">
                  <h4>Adres odbioru:</h4>
                  <ul>
                    <li class="street-address">Prosta 51</li>
                    <li class="city-address">Warszawa</li>
                    <li class="city-zipCode">99-098</li>
                    <li class="phoneNumber">123 456 789</li>
                  </ul>
                </div>

                <div class="form-section--column">
                  <h4>Termin odbioru:</h4>
                  <ul>
                    <li class="orderDate">13/12/2018</li>
                    <li class="orderTime">15:40</li>
                    <li class="orderDescription">Brak uwag</li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="submit" class="btn">Potwierdzam</button>
            </div>
          </div>
        </form:form>
      </div>
    </section>

<jsp:include page="static/footer.jsp"/>
