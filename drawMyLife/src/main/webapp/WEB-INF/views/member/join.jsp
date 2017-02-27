<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>
<style>
			
			.agreement .substance {
				background-color:rgb(255,255,230);
				width: 100%;
				height : 300px;
				overflow: scroll;
				overflow-x:hidden
			}
		</style>
<div class="content">
	
	
	<div class="w3-card">
	<form id="joinForm" action="${contextPath }/member/join" method="post">
	<div class="w3-container w3-green">
      <h2>회원가입</h2>
    </div>
    <center><h4>이용약관</h4></center>
	<%@include file="./privateAgreement.jsp" %>
		<div class="w3-container w3-lime">
      		<h6>아이디</h6>
      		<input type="text" class="w3-input input_ani2" name="muid" id="muid" placeholder="아이디 영어로">
      	</div>		
		<div class="w3-container w3-lime">
      		<h6>이메일</h6>
      		<input type="text" class="w3-input input_ani2" name="email" id="email_form" placeholder="ex) drawMyLife@naver.com">
      	</div>
      	<div class="w3-container w3-lime">
      		<h6>이름</h6>
      		<input type="text" class="w3-input input_ani2" name="mname" id="mname" placeholder="ex) 주현태">
      	</div>
      	<div class="w3-container w3-lime">
      		<h6>패스워드</h6>
      		<input type="password" class="w3-input input_ani2 " name="pwd" id="pwd_form" placeholder="********">
      	</div>
      	<div class="w3-container w3-lime">
      		<h6>패스워드확인</h6>
      		<input type="password" class="w3-input input_ani2" name="pwdcheck" id="pwdcheck" placeholder="********">
      	</div>	
		<div class="w3-container w3-lime">
		<button class="btn2" type="button" onclick="join()">회원가입</button>
		</div>
		</form>
	</div>
	
	<script>
		function join(){
			
			if(!$("#agreementCheck").is(":checked"))
			{			
				alert('개인정보 방침에 동의하셔야 합니다.');
				return;
			}
			if(!emailcheck( $('#email_form').val() ))
			{
				alert('이메일 형식이 아닙니다.');
				$('#email_form').val('');
				$('#email_form').focus();
				return;
			}
			if(!inputLengthCheck($('#mname').val(),1))
			{
				alert('이름을 두 자 이상 입력하시오');
				$('#mname').val('');
				$('#mname').focus();
				return;
			}
			if($('#pwdcheck').val() != $('#pwd_form').val())
			{
				alert('비밀번호와 비밀번호체크가 같지 않습니다.');
				$('#pwdcheck').val('');
				$('#pwdcheck').focus();
				return;
			}
			$("#joinForm").submit();
			
		}
		
	</script>
</div>
</div>
</div>

</body>
</html>

