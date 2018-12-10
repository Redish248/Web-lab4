import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {Button} from 'primereact/button';
import {Password} from 'primereact/password';
import {InputText} from 'primereact/inputtext';

//TODO: переходы надо добавить и что-то сделать с кнопкой регистрации
class LogInForm extends Component {
    render() {
        return (
            <form id="forma" method="post" action="/registration/checkUser">
                <h1>Вход:</h1>

                <h3>Имя пользователя:</h3>
                <InputText id="login" keyfilter={/[^\s]/}/>


                <h3>Пароль:</h3>
                <Password id="pswd" feedback={false}/>
                <br/><br/>

                <Button label="Войти" onClick="validate()" onSubmit="registration/checkUser"/>

            </form>
        );
    }
}


/*function validate() {
    var login = document.getElementById("login");
    var pswd = document.getElementById("pswd");
    var errorMes = "kek";
    var success = true;
    if (isNaN(login) || isNaN(pswd) || login.search(/^\s+$/) !== -1){
        success = false;
    }
    var error = document.getElementById("error");
    if (success){
        return true;
    } else {
        error.innerHTML = errorMes;
        return false;
    }
}

function removeError() {
    var error = document.getElementById("error");
    error.innerHTML = "<br/>";
}

let form = document.getElementById("forma");

form.addEventListener('submit', function (event) {
    removeError();
    validate();
});

*/
export default LogInForm;