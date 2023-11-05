const fullnameEl = document.querySelector('#inputFullName');
const phoneEl = document.querySelector('#inputPhone');
const addressEl = document.querySelector('#inputAddress');
const form = document.querySelector('#form');


const checkFullname = () => {

    let valid = false;

    const min = 3,
            max = 25;

    const fullname = fullnameEl.value.trim();

    if (!isRequired(fullname)) {
        showError(fullnameEl, 'Fullname cannot be blank.');
    } else if (!isBetween(fullname.length, min, max)) {
        showError(fullnameEl, `Fullname must be between 3 and 23 characters.`);
    } else {
        showSuccess(fullnameEl);
        valid = true;
    }
    return valid;
};


const checkPhone = () => {
    let valid = false;
    const phone = phoneEl.value.trim();

    if (!isRequired(phone)) {
        showError(phoneEl, 'Phone cannot be blank.');
    } else if (!validPhonePattern.test(phone)) {
        showError(phoneEl, 'Phone can only contain numbers and start with 0');
    } else {
        showSuccess(phoneEl);
        valid = true;
    }

    return valid;
};

const checkAddress = () => {
    let valid = false;
    const address = addressEl.value.trim();

    if (!isRequired(address)) {
        showError(addressEl, 'Address cannot be blank.');
    } else {
        showSuccess(addressEl);
        valid = true;
    }

    return valid;
};


const validPhonePattern = /^[0-9]+$/;

const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    // get the form-field element
    const groupInput = input.parentElement;
    // add the error class
    groupInput.classList.remove('success');
    groupInput.classList.add('error');

    // show the error message
    const error = groupInput.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    // get the form-field element
    const groupInput = input.parentElement;

    // remove the error class
    groupInput.classList.remove('error');
    groupInput.classList.add('success');

    // hide the error message
    const error = groupInput.querySelector('small');
    error.textContent = '';
};


form.addEventListener('submit', function (e) {
    // prevent the form from submitting
    e.preventDefault();

    // validate fields
    let isFullnameValid = checkFullname(),
            isAddressValid = checkAddress(),
            isPhoneValid = checkPhone();

    let isFormValid = isFullnameValid &&
            isAddressValid &&
            isPhoneValid;

    // submit to the server if the form is valid
    if (isFormValid) {
        form.submit();
    }
});


const debounce = (fn, delay = 500) => {
    let timeoutId;
    return (...args) => {
        // cancel the previous timer
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        // setup a new timer
        timeoutId = setTimeout(() => {
            fn.apply(null, args);
        }, delay);
    };
};

form.addEventListener('input', debounce(function (e) {
    switch (e.target.id) {
        case 'fullname':
            checkFullname();
            break;
        case 'address':
            checkAddress();
            break;
        case 'phone':
            checkPhone();
            break;
    }
}));

function openImagePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "flex";
}

function closeImagePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
}

