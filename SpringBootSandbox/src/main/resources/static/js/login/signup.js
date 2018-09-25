
var User = {
    FirstName: '',
    LastName: '',
    Email: '',
    Password: '',
    CPassword: ''
};

$(document).ready(() => {
    $('#inputFirstname').on('change', (e) => {
        User.FirstName = e.target.value;
        onUpdate();
    });

    $('#inputLastname').on('change', (e) => {
        User.LastName = e.target.value;
        onUpdate();
    });

    $('#inputEmail').on('change', (e) => {
        User.Email = e.target.value;
        onUpdate();
    });

    $('#inputPassword').on('change', (e) => {
        User.Password = e.target.value;
        onUpdate();
    });

    $('#inputConfirmPassword').on('change', (e) => {
        User.CPassword = e.target.value;
        onUpdate();
    });

    $('#submitBtn').on('click', (e) => {
        e.preventDefault();
        let valid = true;

        if (User.FirstName == '') {
            $('#firstnameContainer').addClass("has-error");
            valid = false;
        } else {
            $('#firstnameContainer').removeClass("has-error");
        }

        if (User.LastName == '') {
            $('#lastnameContainer').addClass("has-error");
            valid = false;
        } else {
            $('#lastnameContainer').removeClass("has-error");
        }

        if (User.Email == '') {
            $('#emailContainer').addClass("has-error");
            valid = false;
        } else {
            $('#emailContainer').removeClass("has-error");
        }

        if (User.Password == '' || User.Password !== User.CPassword) {
            if (User.Password !== User.CPassword) {
                $('#passwordMatchValid').removeClass("hidden");
            }
            $('#passwordContainer').addClass("has-error");
            valid = false;
        } else {
            $('#passwordMatchValid').addClass("hidden");
            $('#passwordContainer').removeClass("has-error");
        }

        if (User.CPassword == '' || User.Password !== User.CPassword) {
            $('#passwordCContainer').addClass("has-error");
            valid = false;
        } else {
            $('#passwordCContainer').removeClass("has-error");
        }


        if (!isEmailValid(User.Email)) {
            $('#emailContainer').addClass("has-error");
            valid = false;
        } else {
            $('#emailContainer').removeClass("has-error");
        }

        if (User.Password.length < 8 || User.Password > 16) {
            $('#passwordLengthValid').removeClass("hidden");
            $('#passwordContainer').addClass("has-error");
            $('#passwordCContainer').addClass("has-error");
            valid = false;
        } else {
            $('#passwordLengthValid').addClass("hidden");
            $('#passwordContainer').removeClass("has-error");
            $('#passwordCContainer').removeClass("has-error");
        }
        if (valid) {
            $('#signin-form').submit();
        }
    });
});


function onUpdate() {
    if (User.Password.length >= 8 && User.Password.length <= 16) {
        e
        $('#passwordContainer').removeClass("has-error");
        $('#passwordCContainer').removeClass("has-error");
    } else {
        $('#passwordContainer').addClass("has-error");
        $('#passwordCContainer').addClass("has-error");
    }
}


function isEmailValid(email) {
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email);
}