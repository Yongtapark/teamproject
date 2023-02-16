<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>상품 목록</h2>
    </div>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary float-end" onclick="location.href='items/add'" type="button">상품
                등록
            </button>
        </div>
    </div>
    <hr class="my-4">
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
                <th>수량</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>
                        <c:url value="/basic/items/${item.id}" var="itemUrl"/>
                        <a href="${itemUrl}">${item.id}</a>
                    </td>
                    <td>
                        <c:url value="/basic/items/${item.id}" var="itemUrl"/>
                        <a href="${itemUrl}">${item.item_Name}</a>
                    </td>
                    <td>${item.price}</td>
                    <td>${item.quantity}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div> <!-- /container -->
</body>
</html>
