
document.addEventListener("DOMContentLoaded", function() {
const divError = document.getElementById('div__error-mess');
const close = document.getElementById('div__error-close');
console.log(divError);
console.log(close);
divError.style.top = "32px";
setTimeout(() => {
    hideError();
}, 5000); // 3 giây
close.addEventListener("click",function(){
    hideError();
});
function hideError(){
    divError.style.top = "-100%";
}
});