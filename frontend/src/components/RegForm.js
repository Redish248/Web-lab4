import React, { Component } from 'react';
//import './App.css';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {Button} from 'primereact/button';
import {Password} from 'primereact/password';
import {InputText} from 'primereact/inputtext';
import ReactDOM from "react-dom";

class RegForm extends Component {
    render() {
        return (
            <form method="post" action="/registration">
                <h1>Регистрация:</h1>

                <h3>Имя пользователя:</h3>
                <InputText />


                <h3>Пароль:</h3>
                <Password />
                <br/><br/>

                <Button label="Регистрация" /*onClick="/registration/addUser"*/ />
            </form>
        );
    }
}

export default RegForm;
