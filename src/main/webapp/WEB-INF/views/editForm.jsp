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
        <h2>상품 수정 폼</h2>
    </div>
    <form action="../${itemId}/edit" method="post">
        <div>
            <label for="id">상품 ID</label>
            <input type="text" id="id" name="id" class="form-control" value="${item.id}"
                   readonly>
        </div>
        <div>
            <label for="item_Name">상품명</label>
            <input type="text" id="item_Name" name="item_Name" class="form-
control" value=${item.item_Name}>
        </div>
        <div>
            <label for="price">가격</label>
            <input type="text" id="price" name="price" class="form-control"
                   value=${item.price}>
        </div>
        <div>
            <label for="quantity">수량</label>
            <input type="text" id="quantity" name="quantity" class="form-control" value=${item.quantity}>
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">저장</button>
            </div>
            <div class="col">
                <c:url value="/basic/items/${item.id}" var="itemUrl"/>
                <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='${itemUrl}'" type="button">Cancel</button>
            </div>
            <div class="col">
                <c:url value="/basic/items/${item.id}/delete" var="itemUrl"/>
                <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='${itemUrl}'" type="button">삭제</button>
            </div>
        </div>
    </form>
</div> <!-- /container -->
</body>
</html>
