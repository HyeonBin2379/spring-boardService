<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Board Detail View</title>
</head>
<body>
<div class="card-body">
    <div class="input-group mb-3">
        <span class="input-group-text">게시글 번호</span>
        <input type="text" name="bId" class="form-control" value='<c:out value="${board.getBId()}"></c:out>' readonly>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">제목</span>
        <input type="text" name="title" class="form-control"  value='<c:out value="${board.getTitle()}"></c:out>' readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">작성자</span>
        <input type="text" name="writer" class="form-control"  value='<c:out value="${board.getWriter()}"></c:out>' readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">게시글 내용</span>
        <textarea name="content" class="form-control" readonly><c:out value="${board.getContent()}"></c:out></textarea>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">조회수</span>
        <input type="text" name="hits" class="form-control"  value='<c:out value="${board.getHits()}"></c:out>' readonly/>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">작성날짜</span>
        <input type="datetime-local" name="createdDate" class="form-control"  value='<c:out value="${board.getCreatedDate()}"></c:out>' readonly/>
    </div>

    <div class="mb-3">
        <input class="form-control" type="file" id="formFile" value="${board.getFile()}" readonly>
    </div>

    <div class="mb-4">
        <div class="float-end">
            <button type="button" class="btn btn-primary">Modify</button>
            <button type="button" class="btn btn-secondary">List</button>
        </div>

    </div>
    <script>
        document.querySelector(".btn-primary").addEventListener("click",function (e) {
            self.location = "/board/modify?bId=${board.getBId()}&${pageRequestDTO.link}"
        },false)

        document.querySelector(".btn-secondary").addEventListener("click", function (e) {
            self.location ="/board/list?${pageRequestDTO.link}";
        },false)
    </script>

</div>


<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->
</body>
</html>