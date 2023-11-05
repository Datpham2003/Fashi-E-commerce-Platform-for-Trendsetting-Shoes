const form = document.getElementById('checkoutform');
const name = document.getElementById('name');
const country = document.getElementById('country');
const street = document.getElementById('street');
const city = document.getElementById('city');
const phone = document.getElementById('phone');
const messege = document.getElementById('messege');
const code = document.getElementById('code');
const errorElement = document.getElementById('error');


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
    let isValid = true;
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
        isValid = false;
    } else if (nameValue.length > 20) {
        setError(name, 'Name must be less than 20 characters');
        isValid = false;
    } else if (!validNamePattern.test(nameValue)) {
        setError(name, 'Name can only contain letters and numbers');
        isValid = false;
    } else {
        setSuccess(name);
    }

    if (countryValue === '') {
        setError(country, 'Country is required');
        isValid = false;
    } else if (countryValue.length > 60) {
        setError(country, 'Country must be less than 60 characters');
        isValid = false;
    } else {
        setSuccess(country);
    }

    if (streetValue === '') {
        setError(street, 'Street is required');
        isValid = false;
    } else if (streetValue.length > 20) {
        setError(street, 'Street must be less than 60 characters');
        isValid = false;
    } else {
        setSuccess(street);
    }

    if (cityValue === '') {
        setError(city, 'City is required');
        isValid = false;
    } else if (cityValue.length > 20) {
        setError(city, 'City must be less than 20 characters');
        isValid = false;
    } else {
        setSuccess(city);
    }

    if (phoneValue === '') {
        setError(phone, 'Phone is required');
        isValid = false;
    } else if (phoneValue.length > 11) {
        setError(phone, 'Phone must be less than 11 number');
        isValid = false;
    } else if (!validPhonePattern.test(phoneValue)) {
        setError(phone, 'Phone can only contain numbers');
        isValid = false;
    } else {
        setSuccess(phone);
    }

    if (messegeValue.length > 100) {
        setError(messege, 'Messege must be less than 100 characters');
        isValid = false;
    } else {
        setSuccess(messege);
    }

    if (codeValue.length > 10) {
        setError(code, 'code must be less than 10 characters');
        isValid = false;
    } else {
        setSuccess(code);
    }

    return isValid;
};

form.addEventListener('submit', function (e) {
    e.preventDefault();

    let isFormValid = validateInputs();
    if (isFormValid) {
        form.submit();
    }
});