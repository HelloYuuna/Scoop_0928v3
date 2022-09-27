    $(document).ready(function () {
        $('#submit-btn').on('click', idChk);
    });

    function submitFalse() {
        return false;                               // submit 버튼 비활성
    }

    function idChk() {
        let email = $('#email').val();
        console.log(email);

        $.ajax({
            url:'idcheck' ,
            type: 'post',
            data: { email:email } ,
            dataType: "JSON" ,
            success: function(result) {
                console.log(result);

                // true: 아이디존재 -> 중복
                if(!result) {
                    $('#idchk-msg').html('해당 아이디는 이미 존재합니다.')
                        .select();
                } else {
                    // 중복체크를 확인했으니 회원가입으로 진행
                    signup();
                }

            } ,
            error: function(e) {
                alert('참고로 에러는 안떠요');
                JSON.stringify(e);
            }
        });
    }
    
    // 회원가입 form 데이터를 member테이블로 저장
    function signup() {
        let formData = $('#signupForm').serialize();
        console.log('signup 메소드' + formData);

        $.ajax({
            url: 'signup',
            type: 'post',
            data: formData,
            success: function(result) {
                console.log(result);

                if(result >= 1) {
                    let gotoLoginPage = '/';
                    alert('회원가입이 완료되었습니다.');
                    location.href=gotoLoginPage;
                }

            } ,
            error: function (e) {
                JSON.stringify(e);
            }
        });
    }