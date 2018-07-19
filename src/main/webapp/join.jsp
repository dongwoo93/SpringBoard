<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동우교 회원가입</title>
<style>
        table {}

        .menu {
            text-align: right;
        }

        .tel {
            width: 80px;
        }

        .content {
            width: 350px;
        }

        #result {
            display: inline;
        }
    </style>

    <script>
        var nameregex = /[^ㄱ-ㅎㅏ-ㅣ가-힣]/; // 한글
        var telregex = /[^0-9]/; // 전화번호
        var telregex2 = /^.{4}$/;
        var addressregex = /[a-z]/; // 주소
        var nameregex2 = /^.{2,}$/; // 두 글자 이상

        function comparison(input1, input2) {
            if (input1 == input2 && !(input1 == "")) {
                return true;
            } else {
                return false;
            }
        }
        window.onload = function() {
           
            var resultStyle = document.getElementById("result").style;
            document.getElementById("pass2").onkeyup = function() {
                var text1 = document.getElementById("pass1").value;
                var text2 = document.getElementById("pass2").value;
                var result = comparison(text1, text2);
                if (result) {
                    document.getElementById("result").innerHTML = "패스워드가 일치합니다";
                    resultStyle.color = "blue";
                } else {
                    document.getElementById("result").innerHTML = "패스워드가 일치하지 않습니다";
                    resultStyle.color = "red";
                }
            }
            document.getElementById("pass2").onclick = function() {
                var text1 = document.getElementById("pass1").value;
                var text2 = document.getElementById("pass2").value;
                var result = comparison(text1, text2);
                if (result) {
                    document.getElementById("result").innerHTML = "패스워드가 일치합니다";
                    resultStyle.color = "blue";
                } else {
                    document.getElementById("result").innerHTML = "패스워드가 일치하지 않습니다";
                    resultStyle.color = "red";
                }
            }
            document.getElementById("namein").oninput = function() {
                var text1 = document.getElementById("namein").value;
                var result = nameregex.test(text1);
                if (result) {
                    document.getElementById("namein").value = text1.replace(nameregex, "");
                }
            }

            document.getElementById("tel1").oninput = function() {
                var text1 = document.getElementById("tel1").value;
                var result = telregex.test(text1);
                if (result) {
                    document.getElementById("tel1").value = text1.replace(telregex, "");
                }
            }

            document.getElementById("tel2").oninput = function() {
                var text1 = document.getElementById("tel2").value;
                var result = telregex.test(text1);
                if (result) {
                    document.getElementById("tel2").value = text1.replace(telregex, "");
                }
            }

            document.getElementById("sample6_address2").oninput = function() {
                var text1 = document.getElementById("sample6_address2").value;
                var result = addressregex.test(text1);
                if (result) {
                    document.getElementById("sample6_address2").value = text1.replace(addressregex, "");
                }
            }

            document.getElementById("namein").addEventListener("focusout", myFunction);
            function myFunction() {
                var text1 = document.getElementById("namein").value;
                var result = nameregex2.test(text1);
                if(!result){
                    alert("올바른 이름이 아닙니다");
                    document.getElementById("namein").value = "";
                }
            }
            
            document.getElementById("tel2").addEventListener("focusout", myFunction2);
            function myFunction2() {
                var text1 = document.getElementById("tel1").value;
                var text2 = document.getElementById("tel2").value;
                var result = telregex2.test(text1);
                var result2 = telregex2.test(text2);
                if(!(text1==""&&text2=="")&&(!result || !result2)){
                    alert("전화번호가 올바르지 않습니다");
                    document.getElementById("tel1").value = "";
                    document.getElementById("tel2").value = "";
                    document.getElementById("tel1").focus();
                }
            }
            
            function makeFunction(dst) {
        		document.getElementById("postform").action = dst;
        	    document.getElementById("postform").submit();	
        	}
        	
        	function check() {
        		var id = document.getElementById("id1").value;
        		var pass = document.getElementById("pass2").value;
        		var name = document.getElementById("namein").value;
        		
        		if(id != "" && pass != "" && name != "") {
        			alert("동우교 유효성 통과");
        			return true;
        		} else {
        			alert("모두 입력해주세요!!");
        			return false;
        		}
        		
        	}
            
            document.getElementById("join").onclick = function() {
            	var result = check();
    			if(result) {
    				makeFunction("joinProc.do");
    			}
            }
            
        }
    </script>
</head>

<body>
<form id="postform" method="post">
    <div id="wrapper">
        <table border="1">
            <tr>
                <th colspan="2">동우교 회원 가입 정보</th>
            </tr>
            <tr>
                <td class="menu">아이디 :</td>
                <td class="content">
                    <input type="text" id="id1" name="id">
                </td>
            </tr>

            <tr>
                <td class="menu">비밀번호 :</td>
                <td class="content"><input id="pass1" type="text" name="pw"></td>
            </tr>

            <tr>
                <td class="menu">비밀번호 확인 :</td>
                <td class="content"><input id="pass2" type="text">
                    <div id="result" style="font-size: 12px"></div>
                </td>
            </tr>

            <tr>
                <td class="menu">이름 :</td>
                <td class="content">
                    <input type="text" id="namein" name="name">
                </td>
            </tr>

            <tr>
                <td class="menu">전화번호 :</td>
                <td class="content">
                    <select name="phone1" class="txt_12px_01">
                          <option value="02">02</option>
                          <option value="031">031</option>
                          <option value="032">032</option>
                          <option value="033">033</option>
                          <option value="041">041</option>
                          <option value="042">042</option>
                          <option value="043">043</option>
                          <option value="051">051</option>
                          <option value="052">052</option>
                          <option value="053">053</option>
                          <option value="054">054</option>
                          <option value="055">055</option>
                          <option value="061">061</option>
                          <option value="062">062</option>
                          <option value="063">063</option>
                          <option value="064">064</option>
                     </select> - <input type="text" class="tel" id="tel1" name="phone2"> - <input type="text" class="tel" id="tel2" name="phone3">
                </td>
            </tr>

            <tr>
                <td class="menu">이메일 :</td>
                <td class="content">
                    <input type="text" id="email1" name="email">
                </td>
            </tr>

            <tr>
                <td class="menu">우편번호 :</td>
                <td class="content"><input type="text" id="sample6_postcode" name="zipcode" placeholder="우편번호" readonly>
                    <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></td>
            </tr>

            <tr>
                <td class="menu">주소1 :</td>
                <td class="content"><input type="text" id="sample6_address" name="address1" placeholder="주소" readonly></td>
            </tr>

            <tr>
                <td class="menu">주소2 :</td>
                <td class="content"><input type="text" id="sample6_address2" name="address2" placeholder="상세주소"></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button id="join" type="submit">회원가입</button>
                    <button id="reinput" type="button">다시입력</button>
                </td>
            </tr>

            <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
            <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
            <script>
                function sample6_execDaumPostcode() {
                    new daum.Postcode({
                        oncomplete: function(data) {
                            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                            var fullAddr = ''; // 최종 주소 변수
                            var extraAddr = ''; // 조합형 주소 변수

                            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                                fullAddr = data.roadAddress;

                            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                                fullAddr = data.jibunAddress;
                            }

                            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                            if (data.userSelectedType === 'R') {
                                //법정동명이 있을 경우 추가한다.
                                if (data.bname !== '') {
                                    extraAddr += data.bname;
                                }
                                // 건물명이 있을 경우 추가한다.
                                if (data.buildingName !== '') {
                                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                }
                                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                                fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
                            }

                            // 우편번호와 주소 정보를 해당 필드에 넣는다.
                            document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                            document.getElementById('sample6_address').value = fullAddr;

                            // 커서를 상세주소 필드로 이동한다.
                            document.getElementById('sample6_address2').focus();
                        }
                    }).open();
                }
            </script>
        </table>
    </div>
    </form>

</body>
</html>