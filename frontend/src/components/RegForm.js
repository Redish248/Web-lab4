import React, { Component } from 'react';

import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

import {Button} from 'primereact/button';
import {Password} from 'primereact/password';
import {InputText} from 'primereact/inputtext';

//import { createStore } from 'redux';

class RegForm extends Component {
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
    render() {
        return (
            <form method="post" onSubmit={this.handleSubmit.bind(this)} /*action="/registration"*/>
                <h1>Регистрация:</h1>

                <h3>Имя пользователя:</h3>
                <InputText keyfilter={/[^\s]/} value={this.state.nick} onChange={this.handleNickChange.bind(this)}/>

                <h3>Пароль:</h3>
                <Password  value={this.state.password} onChange={this.handlePasswordChange.bind(this)}/>
                <br/><br/>

                <Button  label="Регистрация" /*onClick="/registration/addUser"*/ />
            </form>
        );
    }
}


/*
TODO: redux надо добавить .-.
function playlist(state = [], action) {
    if (action.type === 'ADD_TRACK') {
        return [
            ...state,
            action.payload
        ]
    }
    return state;
}

const store = createStore(playlist);
console.log(store.getState());

store.subscribe(() => {
    console.log(store.getState());
});
store.dispatch({ type: 'ADD_TRACK', payload: 'kek' });
store.dispatch({ type: 'ADD_TRACK', payload: 'lol' });

const addTrackBtn = document.querySelectorAll('.addTrack')[0];
addTrackBtn.addEventListener('click', () => {
    const trackName = document.querySelectorAll('.trackInput')[0].value;
    console.log('track name', trackName);
});
*/

export default RegForm;
