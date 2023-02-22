<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 1rem;
        }

        header nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: space-between;
        }

        header nav a {
            color: #fff;
            text-decoration: none;
            padding: 1rem;
            display: block;
        }

        main {
            padding: 1rem;
        }

        #signup-form form {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 50%;
            margin: 0 auto;
        }

        #signup-form label,
        #signup-form input[type="submit"] {
            width: 100%;
            margin-bottom: 0.5rem;
        }
        #memberinfo{
            border-left: solid
        }


        footer {
            text-align: center;
            padding: 1rem;
        }
    </style>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="mypage.js"></script>
</head>
<body>
<form method="post" action="" name="frm">
    <input type="hidden" name="memberNo" value="${member.memberNo}">
    <div id="memberinfo">
        <table>
            <tr>
                <th>아이디</th>
                <td><input type="text" id="id" name="id" value="${member.memberId}"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" id="pwd" name="pwd" value="${member.memberPassword}"></td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                <td><input type="password" id="pwdCheck" name="pwdCheck" value="${member.memberPassword}"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" id="name" value="${member.memberName}"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" value="${member.memberEmail}" size="16" id="email1"> @
                    <input type="text" size="20" id="email2" value="naver.com">
                    <select name="emails" id="emails" size="1" onchange="mailCheck()">
                        <option value="naver.com" selected>naver.com</option>
                        <option value="hanmail.net">hanmail.net</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="nate.com">nate.com</option>
                        <option value="1">직접입력</option>
                    </select></td>
            </tr>
            <tr>
                <th>휴대폰 번호</th>
                <td><select name="firstnum" size="1" id="firstnum">
                    <option value="010">010</option>
                    <option value="011">011</option>
                    <option value="013">013</option>
                    <option value="017">017</option>
                    <option value="018">018</option>
                </select>-<input type="text" size="4" maxlength="4" minlength="4" name="secnum" id="secnum" value="${member.memberPhone[1]}">-
                    <input type="text" size="4" maxlength="4" minlength="4" name="thrnum" id="thrnum" value="${member.memberPhone[2]}"></td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" id="sample6_postcode" placeholder="우편번호" readonly>
                    <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                    <input type="text" id="sample6_address" placeholder="주소" readonly>
                    <input type="text" id="sample6_detailAddress" placeholder="상세주소">
                    <!--<input type="text" id="sample6_extraAddress" placeholder="참고항목">-->
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="변경" onclick="infocheck()"><input type="button" onclick="location.href='mypage.html'" value="취소"></td>
            </tr>
        </table>
    </div>
</form>

</body>
</html>