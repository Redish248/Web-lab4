import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {Button} from 'primereact/button';
import {Password} from 'primereact/password';
import {InputText} from 'primereact/inputtext';

class LogInForm extends Component {
    constructor(props) {
        super(props);
        this.state = {nick: '',
        password: ''};
    }

    handleSubmit(event) {
        event.preventDefault();
        alert(this.state.nick + " " + this.state.password);
    }

    handleNickChange(event) {
        this.setState({nick: event.target.value});
    }

    handlePasswordChange(event) {
        this.setState({password: event.target.value});
    }

     home(e) {
        e.preventDefault();
        window.location = './main.html';
    }

    render() {
        return (
            <form id="forma" /*method="post" action="/registration/checkUser"*/ onSubmit={this.handleSubmit.bind(this)}>
                <h1>Вход:</h1>

                <h3>Имя пользователя:</h3>
                <InputText id="login" keyfilter={/[^\s]/} value={this.state.nick} onChange={this.handleNickChange.bind(this)}/>


                <h3>Пароль:</h3>
                <Password id="pswd" feedback={false}  value={this.state.password} onChange={this.handlePasswordChange.bind(this)} />
                <br/><br/>

                <Button label="Войти" onClick={this.home.bind(this)}/*onClick="validate()" onSubmit="registration/checkUser"*//>

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