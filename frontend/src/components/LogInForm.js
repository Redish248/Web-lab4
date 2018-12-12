import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {Button} from 'primereact/button';
import {Password} from 'primereact/password';
import {InputText} from 'primereact/inputtext';
import {withRouter} from 'react-router-dom'

class LogInForm extends Component {
    constructor(props) {
        super(props);
        this.state = {nick: '',
        password: ''};
    }

    handleSubmit = (event) => {
        event.preventDefault();
        //alert(this.state.nick + " " + this.state.password);
        this.props.history.push('/main');
    };

    handleNickChange(event) {
        this.setState({nick: event.target.value});
    }

    handlePasswordChange(event) {
        this.setState({password: event.target.value});
    }



    render() {
        return (
            <form id="formLogIn" /*method="post" action="/registration/checkUser"*/ onSubmit={this.handleSubmit}>
                <h1>Вход:</h1>

                <h3>Имя пользователя:</h3>
                <InputText id="login" keyfilter={/[^\s]/} value={this.state.nick} onChange={this.handleNickChange.bind(this)}/>


                <h3>Пароль:</h3>
                <Password id="pswd" feedback={false}  value={this.state.password} onChange={this.handlePasswordChange.bind(this)} />
                <br/><br/>

                <Button label="Войти" /*onClick="validate()" onSubmit="registration/checkUser"*//>

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

let form = document.getElementById("formLogIn");

form.addEventListener('submit', function (event) {
    removeError();
    validate();
});

*/
export default withRouter(LogInForm);