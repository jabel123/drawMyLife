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

function login(contextPath) {
	if (!emailcheck($('#email').val())) {
		alert('이메일 형식을 입력해 주십시오');
		$('#email').val('');
		$('#email').focus();
		return;
	}

	if (!inputLengthCheck($('#pwd').val(), 1)) {
		alert('비밀번호를 입력해 주십시오');
		$('#pwd').val('');
		$('#pwd').focus();
		return;
	}
	$.ajax({
		url : contextPath + '/member/login',
		type : 'post',
		dataType : 'json',
		data : $('#target').serialize(),
		success : function(data) {
			if (data.isSucceed == 'iderr') {
				alert('없는 이메일 입니다.');
				$('#email').val('');
				$('#email').focus();
			} else if (data.isSucceed == 'pwerr') {
				alert('비밀번호 에러입니다.');
				$('#pwd').val('');
				$('#pwd').focus();
			} else {
				movePage(contextPath + '/')
			}
		}
	});
}

//로그인시 엔터키 전용
function hitEnterKey(contextPath) {
		
	if (event.keyCode == 13) {
		//엔터 입력시 로그인
		login(contextPath);
	} else {
		event.keyCode == 0;
		return;
	}
}

// home 화면의 그래프 및 일기리스트 출력용
function drawMainBoard(contextPath,muid) {	
	$.ajax({
		url : contextPath + '/member/graph',
		type : 'post',
		data :{
			muid : muid
		},
		dataType : 'json',
		success : function(data) {

			var diaryList = data.diaryArr;

			var mhtml = '';
			if (diaryList.length == 0) {
				mhtml += '<tr>';
				mhtml += '<td>작성된 일기가 없습니다.</td>';
				mhtml += '</tr>';
			} else {
				for (var i = 0; i < diaryList.length; i++) {
					mhtml += '<tr>';
					mhtml += '<td><a href=' + contextPath
							+'/'+muid+  '/board/detail?dno=' + diaryList[i].dno + '>';
					mhtml += diaryList[i].title + '<span class="right">'
							+ diaryList[i].writeDate + '</span>';
					mhtml += '</a></td>';
					mhtml += '</tr>';
				}
			}
			$('#boardList tr').after(mhtml);

			$.jqplot('graph', [ data.line ], {
				title : '나의 상태',
				axes : {
					xaxis : {
						label : "날짜",
						// 날짜 형태로 입력을 하기위해서는 Date형식의 Renderer을 사용합니다.
						renderer : $.jqplot.DateAxisRenderer,
						tickOptions : { // 축에관한 옵션
							// 입력된 값이 날짜형태로 인식되기 위해서 format 형식을 정해주고 입력값도
							// yyyy/mm/dd 형식으로 입력해야만 정상적으로 나타납니다.
							formatString : '%y/%m/%d'
						}
					},
					yaxis : {
						label : "평가",
						min : 0
					// formatString:'%y/%m/%d'
					}
				}

			}); // jp
		}
	});
}
