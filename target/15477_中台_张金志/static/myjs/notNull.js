function check(form) {
    if(document.forms.loginForm.name.value==""){
        alert("请输入用户名！");
        document.forms.loginForm.name.focus();
        return false;
    }else {
        return true;
    }
}