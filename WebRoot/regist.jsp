<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

	<head>
	
<script type="text/javascript">
	function isVerify(form) {
		var formName, formPsd, formPsdConfirm;

		with (form) {
			with (username) {
				formName = value;
			}
			with (password) {
				formPsd = value;
			}
			with (psdConfirm) {
				formPsdConfirm = value;
			}

		}
		if (formName == null || formName == "" || formPsd == null
				|| formPsd == "" || formPsdConfirm == null
				|| formPsdConfirm == "") {
			alert("请完善注册信息");
			return false;
		}

		if (formPsd != formPsdConfirm) {
			alert("密码与确认密码不一致");

			return false;
		}
		return true;
	}
</script>
		
	
		<!-- Basic -->
    	<meta charset="UTF-8" />

		<title>注册</title>
		
		<!-- Mobile Metas -->
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		
		<!-- Import google fonts -->
        <link href="http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css" />

		
	    <!-- start: CSS file-->
		
		<!-- Vendor CSS-->
		<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- Plugins CSS-->		
		
		<!-- Theme CSS -->
		<link href="assets/css/jquery.mmenu.css" rel="stylesheet" />
		
		<!-- Page CSS -->		
		<link href="assets/css/style.css" rel="stylesheet" />
		<link href="assets/css/add-ons.min.css" rel="stylesheet" />
		
		<style>
			footer {
				display: none;
			}
		</style>
		
		<!-- end: CSS file-->	
	    
		
		<!-- Head Libs -->
		<script src="assets/plugins/modernizr/js/modernizr.js"></script>
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->		
		
	</head>

	<body>
		<!-- Start: Content -->
		<div class="container-fluid content">
			<div class="row">
				<!-- Main Page -->
				<div class="body-register">
					<div class="center-register">
						<a href="#" class="logo pull-left hidden-xs">
							<img src="assets/img/logo.png" height="45" alt="NADHIF Admin" />
						</a>

						<div class="panel panel-register">
							<div class="panel-title-register text-right">
								<h2 class="title "><i class="fa fa-user"></i> Register</h2>
							</div>
							<div class="panel-body">
								<form action="${pageContext.request.contextPath}/regist.action" method="post" onsubmit="return isVerify(this)">
									<div class="form-group">
										<label>姓名：</label>
										<input name="username" type="text" class="form-control" />
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-sm-6">
												<label>密码：</label>
												<input name="password" type="password" class="form-control" />
											</div>
											<div class="col-sm-6">
												<label>请确认密码：</label>
												<input name="psdConfirm" type="password" class="form-control" />
											</div>
										</div>
									</div>

									<div class="row">
										
										<div class="col-sm-8">
											<div class="checkbox-custom checkbox-default">
												<input id="AgreeTerms" name="agreeterms" type="checkbox"/>
												<label for="AgreeTerms">I agree with <a href="#"><small>terms of use</small></a></label>
											</div>
										</div>
										
										<div class="col-sm-4 text-right">
											<button type="submit" class="btn btn-primary hidden-xs bk-margin-top-10">注册</button>
											<button type="submit" class="btn btn-primary btn-block btn-lg visible-xs bk-margin-top-10">注册</button>
										</div>
									</div>
									
									<p>${errorMsg}</p>

									<div class="text-with-hr">
										<span>or</span>
									</div>
									<br />
	
									<p class="text-center">我已经有了账户，我要<a href="./login.jsp"><small>登录</small></a>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Main Page -->
		
							
		
			</div>
		</div><!--/container-->
		
		
		<!-- start: JavaScript-->
		
		<!-- Vendor JS-->				
		<script src="assets/vendor/js/jquery.min.js"></script>
		<script src="assets/vendor/js/jquery-2.1.1.min.js"></script>
		<script src="assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/skycons/js/skycons.js"></script>
		
		<!-- Plugins JS-->
		
		<!-- Theme JS -->		
		<script src="assets/js/jquery.mmenu.min.js"></script>
		<script src="assets/js/core.min.js"></script>
		
		<!-- Pages JS -->
		<script src="assets/js/pages/page-register.js"></script>
		
		<!-- end: JavaScript-->
		
	</body>
	
</html>