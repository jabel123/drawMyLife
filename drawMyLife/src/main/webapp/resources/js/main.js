/**
 * 
 */

function movePage(page) {
	location.href = page;
	// location.replace(page);
}
// 이메일 형식 검사
function emailcheck(strValue) {
	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	// 입력을 안했으면
	if (!inputLengthCheck(strValue, 0)) {
		return false;
	}

	// 이메일 형식에 맞지않으면
	if (!strValue.match(regExp)) {
		return false;
	}
	return true;
}
// 입력 검사
function inputLengthCheck(strValue, len) {
	if (strValue.length > len) {
		return true;
	} else {
		return false;
	}
}

function login(contextPath){
	if(!emailcheck($('#email').val()))
	{
		alert('이메일 형식을 입력해 주십시오');
		$('#email').val('');
		$('#email').focus();
		return;
	}
	
	if(!inputLengthCheck($('#pwd').val(),1))
	{
		alert('비밀번호를 입력해 주십시오');
		$('#pwd').val('');
		$('#pwd').focus();
		return;
	}		
	$.ajax({
        url : contextPath+'/member/login',
        type : 'post',
        dataType : 'json',
        data : $('#target').serialize(),
        success:function(data){
        	if(data.isSucceed=='iderr'){
        		alert('없는 이메일 입니다.');
    			$('#email').val('');
    			$('#email').focus();
        	}
        	else if(data.isSucceed=='pwerr'){
        		alert('비밀번호 에러입니다.');
    			$('#pwd').val('');
    			$('#pwd').focus();
        	}
        	else{
        		movePage(contextPath+'/')
        	}
        }
    });
}
