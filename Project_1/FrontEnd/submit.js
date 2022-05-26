document.getElementById("logout-button").addEventListener("click", logout);

function logout () {
    localStorage.removeItem("current=user");

    window.location.href = "index.html";
}

document.getElementById("submit-form").addEventListener("submit", attemptSubmit);

function attemptSubmit (event) {
    event.preventDefault();

    const type = document.getElementById("typeInput").value; 
    const description = document.getElementById("description").value; 
    const amount = document.getElementById("amount").value; 

    const userId = localStorage.getItem("current-user");

    if(!userid) {
        window.location.href = "index.html"
    } else if (description == ""){ 
        const messageDiv = document.getElementById("message");
        messageDiv.hidden = false;
        messageDiv.innerText = "Cannot submit a request without a description, please specify your reason.";
    } else if (amount == "") {
        const messageDiv = document.getElementById("message");
        messageDiv.hidden = false;
        messageDiv.innerText = "Please make sure you specify the amount you need reimbursed.";
    } else {
        const reimbursement = {id:0, author:userId, description:description, type:type, amount:amount};
        const payload = JSON.stringify(reimbursement);
        sendAjaxRequest("POST", "http://localhost:3000/reimbursements", payload, submitSuccessful, submitFailed, userId);
    }
}

function submitSuccessful(xhr) {
    const messageDiv = document.getElementById("message");
    messageDiv.hidden = false;
    messageDiv.innerText = 'Reimbursement #${xhr.responseText} has been submitted.';
}

function submitFailed(xhr) {
    const messageDiv = document.getElementById("message");
    messageDiv.hidden = false;
    messageDiv.innerText = 'Sorry, Reimbursement Submission has failed.';
}