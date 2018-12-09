import React, { Component } from 'react';
//import './App.css';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {Button} from 'primereact/button';
import {Password} from 'primereact/password';
import {InputText} from 'primereact/inputtext';
import ReactDOM from "react-dom";

//TODO: переходы надо добавить и что-то сделать с кнопкой регистрации
class LogInForm extends Component {
    render() {
        return (
            <form method="post" action="/registration">
                <h1>Вход:</h1>

                <h3>Имя пользователя:</h3>
                    <InputText id="in" />


                <h3>Пароль:</h3>
                <Password feedback={false}/>
                <br/><br/>

                <Button label="Войти" /*onSubmit="registration/checkUser"*//>

            </form>
        );
    }
}

export default LogInForm;