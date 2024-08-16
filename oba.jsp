function showRegisterForm() {
    document.getElementById('register-form').style.display = 'block';
    document.getElementById('login-form').style.display = 'none';
    document.getElementById('main-menu').style.display = 'none';
}

function showLoginForm() {
    document.getElementById('login-form').style.display = 'block';
    document.getElementById('register-form').style.display = 'none';
    document.getElementById('main-menu').style.display = 'none';
}

function registerUser() {
    const name = document.getElementById('reg-name').value;
    const address = document.getElementById('reg-address').value;
    const contactInfo = document.getElementById('reg-contact').value;
    const initialDeposit = document.getElementById('reg-deposit').value;
    const password = document.getElementById('reg-password').value;

    alert(`User ${name} registered successfully!`);
}

function loginUser() {
    const accountNumber = document.getElementById('login-account').value;
    const password = document.getElementById('login-password').value;

    alert(`User with account number ${accountNumber} logged in successfully!`);
    document.getElementById('user-name').innerText = 'User Name';
    document.getElementById('user-account-number').innerText = accountNumber;
    document.getElementById('user-balance').innerText = '1000';

    document.getElementById('login-form').style.display = 'none';
    document.getElementById('user-dashboard').style.display = 'block';
}

function showDepositForm() {
    document.getElementById('deposit-form').style.display = 'block';
    document.getElementById('withdraw-form').style.display = 'none';
    document.getElementById('transfer-form').style.display = 'none';
}

function showWithdrawForm() {
    document.getElementById('withdraw-form').style.display = 'block';
    document.getElementById('deposit-form').style.display = 'none';
    document.getElementById('transfer-form').style.display = 'none';
}

function showTransferForm() {
    document.getElementById('transfer-form').style.display = 'block';
    document.getElementById('deposit-form').style.display = 'none';
    document.getElementById('withdraw-form').style.display = 'none';
}

function deposit() {
    const amount = document.getElementById('deposit-amount').value;
    alert(`Deposited $${amount} successfully!`);
}

function withdraw() {
    const amount = document.getElementById('withdraw-amount').value;
    alert(`Withdrew $${amount} successfully!`);
}

function transferFunds() {
    const recipient = document.getElementById('transfer-recipient').value;
    const amount = document.getElementById('transfer-amount').value;
    alert(`Transferred $${amount} to ${recipient} successfully!`);
}

function viewAccountStatement() {
    document.getElementById('user-dashboard').style.display = 'none';
    document.getElementById('account-statement').style.display = 'block';
    document.getElementById('statement').innerHTML = `
        <p>Deposited $1000</p>
        <p>Withdrew $200</p>
        <p>Transferred $300</p>
    `;
}

function backToDashboard() {
    document.getElementById('account-statement').style.display = 'none';
    document.getElementById('user-dashboard').style.display = 'block';
}

function logout() {
    alert('Logged out successfully!');
    document.getElementById('user-dashboard').style.display = 'none';
    document.getElementById('main-menu').style.display = 'block';
}
