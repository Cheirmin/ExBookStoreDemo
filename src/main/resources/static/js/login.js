$(document).ready(function(){
    // 登录注册校验
    $('.log-btn').click(function(){
        if(form.email.value==''){
            $('.log-status-email').addClass('wrong-entry');
            $('.alert').fadeIn(500);
            // setTimeout( "$('.alert').fadeOut(3000);",5000 );
            document.getElementById("msg").innerHTML="邮箱不能为空！";
        }else if(form.password.value=='') {
            $('.log-status-password').addClass('wrong-entry');
            $('.alert').fadeIn(500);
            setTimeout("$('.alert').fadeOut(3000);", 5000);
            document.getElementById("msg").innerHTML="密码不能为空！";
        }else if(form.password.value.length<6){
            $('.log-status-password').addClass('wrong-entry');
            $('.alert').fadeIn(500);
            setTimeout( "$('.alert').fadeOut(3000);",5000 );
            document.getElementById("msg").innerHTML="密码长度不能短于6位！";
        }else if(form.password1.value!="-1" && form.password1.value != form.password.value){
            $('.log-status-password1').addClass('wrong-entry');
            $('.log-status-password').addClass('wrong-entry');
            $('.alert').fadeIn(500);
            setTimeout( "$('.alert').fadeOut(3000);",5000 );
            document.getElementById("msg").innerHTML="两次密码输入不一致！";
        } else {
            var fo =  document.getElementById("form");
            fo.submit();
        }
    });
});


