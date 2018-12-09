import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import RegForm from './RegForm';
import LogInForm from './LogInForm';
import {Tabs, Tab} from 'react-bootstrap-tabs';


class TabRegister extends Component {

    render() {

        return (
            <Tabs onSelect={(index, label) => console.log(label + ' selected')}>
                <Tab id="tab1" label="Вход"><LogInForm/></Tab>
                <Tab id="tab2" label="Регистрация"><RegForm/></Tab>
            </Tabs>
        );
    }
}


export default TabRegister;


