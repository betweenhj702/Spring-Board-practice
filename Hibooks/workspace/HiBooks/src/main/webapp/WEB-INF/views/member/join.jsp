<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bit.hibooks.setting.MemberModeSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입</title>
	
	<!-- JavaScript -->
	<script src="../assets/js/member_check.js" > </script>
	<c:if test="${!empty joinCode}">
	    <script type="text/javascript">
			var joinCode = ${joinCode}; 	//alert(joinCode);
	    	if(joinCode == <%=MemberModeSet.JOIN_F_EMAIL_EXIST%>){
	    		alert("이미 가입된 이메일입니다");
			}
	    </script>
	</c:if>
	
    <!-- Font Icon -->
    <link href="../assets/fonts/material-icon/css/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <!-- Main css -->
    <link href="../assets/css/sign.css" rel="stylesheet">
    <link href="../assets/css/hibook.css" rel="stylesheet">
</head>
<body>
    
    <div class="main">
        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">회원가입</h2>
                        <form method="POST" class="register-form" id="register-form" action="join.do">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input onchange="checkName()" type="text" name="m_name" id="name" placeholder="이름"/>
                            </div>
                            <span class="error_next_box" id="nameMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input onchange="checkEmail()" type="email" name="m_email" id="email" placeholder="이메일주소"/>
                            </div>
                            <span class="error_next_box" id="emailMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input oninput="checkPass()" type="password" name="m_pwd" id="pass" placeholder="비밀번호"/>
                            </div>
                            <span class="error_next_box" id="passMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input oninput="checkRePass()" type="password" name="re_pass" id="re_pass" placeholder="비밀번호확인"/>
                            </div>
                            <span class="error_next_box" id="re_passMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <label for="phone"><i class="zmdi zmdi-smartphone-android"></i></label>
                                <input onchange="checkPhone()" type="text" name="m_phone" id="phone" placeholder="전화번호"/>
                            </div>
                            <span class="error_next_box" id="phoneMsg" style="color:#757373" aria-live="assertive">( 전화번호는 - 없이 번호만 입력하세요)</span>
                            <div class="form-group">
                                <label for="birth"><i class="zmdi zmdi-calendar"></i></label>
                                <input type="text" name="birth" id="birth" placeholder="생년월일 ex)19910829"/>
                            </div>
                            <span class="error_next_box" id="birthMsg" style="display:none" aria-live="assertive"></span>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span><a href="#" class="term-service">이용정보 동의약관</a>에 모두 동의합니다.</label>
                            </div>
                            <div class="form-group form-button">
                                <input onclick="checkAll()" type="button" name="signup" id="signup" class="form-submit" value="가입하기"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="../assets/img/signup-image.jpg" alt="sing up image"></figure>
                        <a href="signin.html" class="signup-image-link">이미 회원이예요.</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
    
</body>
</html>