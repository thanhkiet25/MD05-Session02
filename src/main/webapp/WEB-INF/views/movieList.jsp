<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
    <style>
        body{
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
       .add{
           text-decoration: none;
            background-color: blue;
           color: white;
           margin-bottom:  10px;
           border: none;
           border-radius: 2px;
           padding:  5px;
        }
       table{
           margin-top:  10px;
           width: 90%;
           border-collapse: collapse;
           border-spacing: 0;
           text-align:center;

       }
       th,td{
           padding: 10px;
           border:  1px solid #ddd;
       }
       th{
           background-color: green;
           color: white;
       }
     .updata{
         display: flex;
         flex-direction: row;
         justify-content:space-evenly;

     }
     .updata a{
         text-decoration: none;
     }
     div{
         text-align: center;
         margin: 20px 0;
         display: flex;
         flex-direction: row;
     }
     div a{
         display: block;
         margin: 10px 10px;
       padding: 5px;
         border: none;
         border-radius: 5px;
         background-color: rosybrown;
         color: white;
         font-size: 16px;
         text-align: center;
         text-decoration: none;
         transition: background-color 0.2s;
         border-radius: 5px;

     }
    </style>
</head>
<body>
<h1>Danh Sách Phim</h1>
<a href="/movies/addMovie" class="add">Thêm Mới Phim </a>
<form action="movies" method="get" class="search">
<input type="text" name="search" value="${search}" placeholder="Tìm kiếm phim hoặc đạo diễn" required/>
    <button type="submit">Tìm kiếm</button>
</form>
<table>
    <thead>
    <tr>
        <th>Tiêu Đề</th>
        <th>Đạo Diễn</th>
        <th>Ngày phát hành</th>
        <th>Điẻm</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.rating}</td>
            <td class="updata">
                <a href="/movies/updataMovie/${movie.id}" >Cập nhật</a>
                <a href="/movies/delete/${movie.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
<div>
    <c:forEach items="${totalPages}" var="i">
        <a href="/movies?page=${i}">${i}</a>
        <p>></p>
    </c:forEach>
</div>
    </tbody>
</table>
</body>
</html>