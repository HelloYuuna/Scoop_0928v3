// 내작업
$(document).ready(function() {
    $('.modalButton').on('click', insertTask);
});

function insertTask() {
    console.log('insertTask');

    let charger = $('#charger');
    // console.log(charger.html());

    $.ajax({
        url: 'insertCharger' ,
        type: 'post' ,
        success: function (name) {
            console.log(name);
            charger.html(name);

        } ,
        error: function(e) {
            JSON.stringify(e);
        }
    });
}