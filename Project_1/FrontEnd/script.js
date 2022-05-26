


const cont = document.getElementById('container');

cont.style.backgroundColor = 'white';
cont.style.position = 'absolute';
cont.style.top ='15%';
cont.style.left='35%';
cont.style.border='solid white';
cont.style.padding='100px';
cont.style.borderRadius='10px';
cont.style.transform='-50%, -50%';
cont.style.zIndex='2';

const btn = document.getElementById('btn');

btn.style.marginLeft='110px';
btn.style.marginTop='25px';
document.getElementById("btn").onclick = function() {
    location.href = "employee.html";
}

const bg = document.getElementById('bg');

bg.style.position='fixed';
bg.style.top='0';
bg.style.left='0';
bg.style.width='100%';
bg.style.height='100%';

const btn2 = document.getElementById('btn2');

btn2.style.marginLeft='100px';
document.getElementById("btn2").onclick = function() {
    location.href = "register.html";
}

const btn3 = document.getElementById('btn3');

btn3.style.marginLeft='110px';


const submit = document.getElementById('submit-anchor');

document.getElementById("submit-anchor").onclick = function() {
    location.href = "submitReimburse.html";
}
// const logo = document.getElementById('logo');

// logo.style.maxHeight="150px";
// logo.style.maxWidth="150px";
