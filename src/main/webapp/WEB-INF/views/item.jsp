<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        .container {
            max-width: 560px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="py-5 text-center">
        <h2>상품 상세</h2>
    </div>
    <c:choose>
        <c:when test="${param.status == 'add'}">
            <h2>저장 완료!</h2>
        </c:when>
        <c:when test="${param.status == 'edit'}">
            <h2>수정 완료!</h2>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>
    <div>
        <label for="itemId">상품 ID</label>
        <input type="text" id="itemId" name="itemId" class="form-control"
               value="${item.id}" readonly>
    </div>
    <div>
        <label for="itemName">상품명</label>
        <input type="text" id="itemName" name="itemName" class="form-control"
               value=${item.item_Name} readonly>
    </div>
    <div>
        <label for="price">가격</label>
        <input type="text" id="price" name="price" class="form-control"
               value=${item.price} readonly>
    </div>
    <div>
        <label for="quantity">수량</label>
        <input type="text" id="quantity" name="quantity" class="form-control"
               value=${item.quantity} readonly>
    </div>
    <hr class="my-4">
    <div class="row">
        <div class="col">
            <c:url value="/basic/items/${item.id}/edit" var="editUrl"/>
            <button class="w-100 btn btn-primary btn-lg" onclick="location.href='${editUrl}'" type="button">상품 수정</button>
        </div>
        <div class="col">
            <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='/basic/items'" type="button">목록으로 이동</button>
        </div>
    </div>

</div>
</body>
</html>
