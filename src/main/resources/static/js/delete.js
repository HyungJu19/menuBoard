
$(function() {
    //글삭제버튼
    $("#btnDel").click(function (){
        let answer = confirm("삭제하시겠습니까?");
        if(answer){
            $("form[name='frmDelete']").submit();
        }
    })

});