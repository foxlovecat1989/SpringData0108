<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <!-- Head -->
        <%@include file="../include/head.jspf"  %>
        
   <script>
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#image').val(e.target.result);
                        $('#previewImage').attr('src', e.target.result);
                        $('#previewImage').attr('width', 100);
                    }
                    reader.readAsDataURL(input.files[0]); // convert to base64 string
                }
            }
            $(document).ready(function () {
                $("#myfile").change(function () {
                    readURL(this);
                });
            });
        </script>
    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="../include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="../include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Product</h1>
                    <h2>商品</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    
                    <td valign="top"><!-- 外框 - 直 -->
                      <!-- 商品表單 -->
                        <form:form class="pure-form" 
                                                    modelAttribute="product" 
                                                    method="post" 
                                                    action="${pageContext.request.contextPath}/mvc/psi/product" >
                            <fieldset>
                                <legend>商品表單</legend>
                                <form:input path="id" readonly="true" /><p />
                                商品名稱 : <br />
                                <form:input path="name" placeholder="請輸入商品名稱" /><p />
                                商品圖片 : <br />
                                <input type="file" name="myfile" id="myfile" /><p />
                                <form:input path="image" readonly="true" /><p />     <!-- 上傳圖片預覽位置 -->
                                <img id="previewImage" src="${ product.image==null || product.image==""? space:product.image }" width="50" /><p />    <!-- 原本圖片預覽位置 -->
                                <input type="text" id="_method" name="_method" value="${ _method }" readonly="true" /><p />
                                <div style="color: red">${ deleteError }</div>
                                <button type="submit" class="pure-button pure-button-primary">Submit</button>
                            </fieldset>
                        </form:form>
                    </td><!-- 外框 - 直 -->
                    
                    <td valign="top"><!-- 外框 - 直 -->
                        <!-- 商品列表 -->
                        <form class="pure-form">
                        <fieldset>
                        <legend>商品列表</legend>
                            <table class="pure-table pure-table-bordered">
                                <thead>
                                    <tr>
                                        <td>ID</td>
                                        <td>Name</td>
                                        <td>Image</td>
                                        <td>Update</td>
                                        <td>Delete</td>
                                    </tr>
                                </thead> 
                                <tbody>
                                    <c:forEach var="product" items="${ products }" >
                                    <tr>
                                        <td>${ product.id }</td> 
                                        <td>${ product.name }</td> 
                                        <td><img src="${ product.image==null || product.image==""? space:product.image }" width="${ product.image==null || product.image==""? 0:50 }" /></td> 
                                        <td><a href="${pageContext.request.contextPath}/mvc/psi/product/${ product.id }">Update</a></td>
                                        <td><a href="${pageContext.request.contextPath}/mvc/psi/product/delete/${ product.id }">Delete</a></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </fieldset>
                        </form>
                    </td><!-- 外框 - 直 -->
                </table>   


            </div>
        </div>

        <!-- Foot -->
        <%@include file="../include/foot.jspf"  %>

    </body>
</html>