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
    
    if (name === '') {
        setError(name,'Name is required');
    } else if(nameValue.length > 20){
        setError(name,'Name must be less than 20 characters');
    }
};