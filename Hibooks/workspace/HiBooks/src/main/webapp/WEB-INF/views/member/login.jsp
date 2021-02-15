<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>로그인</title>
	<!-- JavaScript  -->
	<script type="text/javascript" src="../assets/js/member_check.js"></script>
    
    <!-- Font Icon -->
    <link href="../assets/fonts/material-icon/css/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
	
    <!-- Main css -->
    <link href="../assets/css/sign.css" rel="stylesheet">
    <link href="../assets/css/hibook.css" rel="stylesheet">
</head>
<body>
    <div class="main">
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="../assets/img/signin-image.jpg" alt="sing up image"></figure>
                        <a href="#" class="signup-image-link">Create an account</a>
                    </div>
                    <div class="signin-form">
                        <h2 class="form-title">로그인</h2>
                        <form method="POST" class="register-form" id="login-form" action="login.do">
                            <div class="form-group">
                                <label for="your_email"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input onchange="checkEmail()" type="text" name="m_email" id="email" placeholder="이메일주소"/>
                            </div>
                            <span class="error_next_box" id="emailMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input oninput="" type="password" name="m_pwd" id="pass" placeholder="비밀번호"/>
                            </div>
                            <span class="error_next_box" id="passMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input onclick="checkLogin()" type="button" name="signin" id="signin" class="form-submit" value="로그인"/>
                            </div>
                        </form>
                        <div class="social-login">
                            <span class="social-label">Or login with</span>
                            <ul class="socials">
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>
</html>