import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {TabMenu} from 'primereact/tabmenu';
import RegForm from './RegForm';
import LogInForm from './LogInForm';
import ReactDOM from "react-dom";


class TabRegister extends Component {
    constructor() {
        super();
        this.state = {
            items: [
                {label: 'Вход', icon: 'pi pi-fw pi-home' },
                {label: 'Регистрация', icon: 'pi pi-fw pi-calendar'},
            ]
        };
    }
    render() {
        const formLogIn = this.state.label === this.state.items[0].label && <LogInForm/>;
        const formReg = this.state.label === this.state.items[1].label && <RegForm/>;
        return (
            <div>
                <div className="reg">
                    <TabMenu model={this.state.items}  />
                    {alert('Вход'=== this.state.items[0].label)}
                    <div id="tab">
                        {formLogIn}{formReg}
                    </div>

                </div>
            </div>
        );
    }
}
const form1 = {label: 'Вход', icon: 'pi pi-fw pi-home' };
const form2 = {label: 'Регистрация', icon: 'pi pi-fw pi-calendar'};

export default TabRegister;


