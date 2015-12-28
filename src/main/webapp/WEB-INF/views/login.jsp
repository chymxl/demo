<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/signin.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">请登陆</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="邮件地址" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">记住我
          </label>
        </div>
        <!-- IE默认type='button',其他浏览器和W3C标准type='submit' -->
        <button type="button" class="btn btn-lg btn-primary btn-block" onclick="doSubmit()">登陆</button>
      </form>

    </div> <!-- /container -->

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){
	var user = localStorage.user;
	if(user){
		user = JSON.parse(user);
		$("#inputEmail").val(user.email);
		$("#inputPassword").val(user.password);
	}
});

function doSubmit(){
	var checked = $("input[type='checkbox']").prop("checked");
	var email = $("#inputEmail").val();
	var pwd = $("#inputPassword").val();
	if(checked){
		var user = {};
		user.email = email;
		user.password = pwd;
		localStorage.user = JSON.stringify(user);
	}
	var data = {};
	data.email = email;
	data.password = pwd;
	$.ajax({
		type :'post',
		url : '${pageContext.request.contextPath}/user/signin',
		dataType : 'json',
		data : data,
		success : function(ret){
			if(ret.result){
				location.href = "${pageContext.request.contextPath}/user/showMusic";
			}
			else{
				alert(ret.msg);
			}
		},
		error : function(e){
			alert(JSON.stringify(e));
		}
	});
}
	
</script>

</body>
</html>