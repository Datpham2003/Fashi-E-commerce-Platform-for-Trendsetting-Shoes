/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const form = document.getElementById('checkoutform');
const name = document.getElementById('name');
const country = document.getElementById('country');
const street = document.getElementById('street');
const city = document.getElementById('city');
const phone = document.getElementById('phone');
const messege = document.getElementById('messege');
const code = document.getElementById('code');
const errorElement = document.getElementById('error');

form.addEventListener('submit', e => {
    e.preventDefault();

    validateInputs();
});

const setError = (element, messege) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = messege;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');

};

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');

};

const validateInputs = () => {
    const nameValue = name.value.trim();
    const countryValue = country.value.trim();
    const streetValue = street.value.trim();
    const cityValue = city.value.trim();
    const phoneValue = phone.value.trim();
    const messegeValue = messege.value.trim();
    const codeValue = code.value.trim();
    const validNamePattern = /^[a-zA-Z0-9\s]+$/;
    const validPhonePattern = /^[0-9]+$/;


    if (nameValue === '') {
        setError(name, 'Name is required');
    } else if (nameValue.length > 20) {
        setError(name, 'Name must be less than 20 characters');
    } else if (!validNamePattern.test(nameValue)) {
        setError(name, 'Name can only contain letters and numbers');
    } else {
        setSuccess(name);
    }

    if (countryValue === '') {
        setError(name, 'Country is required');
    } else if (countryValue.length > 60) {
        setError(name, 'Country must be less than 60 characters');
    } else {
        setSuccess(country);
    }

    if (streetValue === '') {
        setError(street, 'Street is required');
    } else if (streetValue.length > 20) {
        setError(street, 'Street must be less than 60 characters');
    } else {
        setSuccess(street);
    }


    if (cityValue === '') {
        setError(street, 'City is required');
    } else if (cityValue.length > 20) {
        setError(street, 'City must be less than 20 characters');
    } else {
        setSuccess(city);
    }

    if (phoneValue === '') {
        setError(phone, 'Phone is required');
    } else if (cityValue.length > 11) {
        setError(phone, 'Phone must be less than 11 number');
    } else if (!validPhonePattern.test(phoneValue)) {
        setError(phone, 'Phone can only contain numbers');
    } else {
        setSuccess(phone);
    }
    
    if (messegeValue.length > 100 ) {
        setError(messege,'Messege must be less than 100 characters');
    } else {
        setSuccess(messege);
    }
    
    if (codeValue.length > 10 ) {
        setError(code,'code must be less than 10 characters');
    } else {
        setSuccess(code);
    }
    
    
};