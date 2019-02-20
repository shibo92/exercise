function reply() {
    var ele = document.getElementById('J_chatContent');
    ele.value = '小米牛比，感动了';
    var btn = document.getElementById('J_sendChatBtn');
    btn.classList.remove('disabled');
    btn.click();
}
Window.setInterval(reply,5000);
clearInterval(reply());