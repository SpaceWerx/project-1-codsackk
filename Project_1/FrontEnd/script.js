


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

const loginBtn = document.getElementById('loginBtn');

loginBtn.style.marginLeft='110px';
loginBtn.style.marginTop='25px';

//document.getElementById("loginBtn").onclick = function() {
 //   location.href = "employee.html";
//}

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

document.getElementById("btn3").onclick = function() {
    location.href = "index.html";
}

const submit = document.getElementById('submit-anchor');

document.getElementById("submit-anchor").onclick = function() {
    location.href = "submitReimburse.html";
}

document.getElementById("loginBtn").addEventListener("click",loginFunction);

async function loginFunction() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    console.log(usern);
    console.log(userp);

    let user = {
        username: usern,
        password: userp
    }

    console.log(user);

    let response = await fetch(url + "login",{
        method: "POST", 
        body: JSON.stringify(user),
        credentials: "include"
    });

    console.log(response.status);

    if(response.status === 201) {
        document.getElementById("loginForm").innerText = "Welcome to the Manager Menu!";
    }
    else if (response.status === 202){
        document.getElementById("loginForm").innerText = "Welcome to the Employee Menu!";
    }
    else {
        document.getElementById("loginForm").innerText = "Login Failed, please refresh the page!";
    }
}

// const logo = document.getElementById('logo');

// logo.style.maxHeight="150px";
// logo.style.maxWidth="150px";
