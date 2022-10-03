// 내작업
$(document).ready(function() {
    $('#btnTaskMake').click(createTask);
});

// 모달창 작업 생성 버튼 액션
function createTask() {

    if( !confirm('작업을 생성하시겠습니까?') ) {
        return;
    }

    // 날짜 유효성 체크
    let startDate = $('#starttime').val();              // 시작 날짜
    let endDate = $('#endtime').val();                  // 종료 날짜

    // console.log('시작 날짜: ', startDate);

    if( startDate !== '' ) {

        // 종료 날짜가 시작날짜보다 전이면 반환
        if (endDate !== '' && endDate < startDate) {
            alert('종료일은 시작일의 다음날로 설정해주세요');
            $('#endtime').css('color', '#fb8500').select();
        }
        return;
    }

    let insertTaskByForm = $('#insertTaskByForm').serialize();
    console.log('폼내용:', insertTaskByForm);

    $.ajax({
        url: 'insertTask',
        type: 'post',
        data: $('#insertTaskByForm').serialize(),
        success: function(res) {
            console.log(res);
            // todo: 리다이렉트 or task 데이터 다시 가져오기
            if (res === 1) {
                // 등록 모달창 닫음
                const modal = document.querySelector(".modal");
                modal.classList.add("hidden");
            }
        } ,
        error: function(e) {
            JSON.stringify(e);
        }
    });

}
