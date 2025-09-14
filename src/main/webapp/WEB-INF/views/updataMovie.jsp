<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
</head>
<body>
<h1>Thêm Phim Mới</h1>
<form:form action="/movies/updataMovie/${movie.id}" modelAttribute="movie" method="post">

    <form:label path="title">Tiêu Đề:</form:label>
    <form:input path="title" value="${movie.title}" />
    <form:errors path="title" cssClass="error"/>

    <form:label path="director">Đạo Diễn:</form:label>
    <form:input path="director" value="${movie.director}" />
    <form:errors path="director" cssClass="error"/>

    <form:label path="releaseDate">Ngày Phát Hành:</form:label>
    <form:input path="releaseDate" type="date" value="${movie.releaseDate}"/>
    <form:errors path="releaseDate" cssClass="error"/>

    <form:label path="rating">Điểm:</form:label>
    <form:input path="rating" type="number" step="0.1" value="${movie.rating}"/>
    <form:errors path="rating" cssClass="error"/>

    <input type="submit" value="Cập Nhật"/>
</form:form>
<a href="/movies">Quay lại</a>
</body>
</html>