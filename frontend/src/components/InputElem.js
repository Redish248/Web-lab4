import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

import {Button} from 'primereact/button';
import {Spinner} from 'primereact/spinner';
import {Slider} from 'primereact/slider';


class InputElem extends Component {

    constructor() {
        super();
        this.state = {
            sliderY: null,
            spinnerX: null,
            spinnerR: null
        };
    }

    handleSubmit(event) {
        event.preventDefault();
        alert(this.state.spinnerX + " " + this.state.sliderY + " " + this.state.spinnerR);
    }

    render() {
        return (
            <form id = "pointForm"/*method="post" action="/checkPoint"*/ onSubmit={this.handleSubmit.bind(this)}>
                <table className="formTableXYR">
                    <tr id="chooseLabel">
                        Выберите данные:
                    </tr>
                    <tr>
                        Координата X:
                    </tr>
                    <tr>
                        <Spinner id="X" min={-5} max={3} value={this.state.spinnerX} onChange={(e) => this.setState({spinnerX: e.value})}/>
                    </tr>
                    <tr>
                        Координата Y: {this.state.sliderY}
                    </tr>
                    <tr>
                        <Slider id= "Y" value={this.state.sliderY} onChange={(e) => this.setState({sliderY: e.value})} style={{width: '14em'}} max ={5} min={-5}/>
                    </tr>
                    <tr>
                        Радиус R:
                    </tr>
                    <tr>
                        <Spinner id="R" min={-5} max={3} value={this.state.spinnerR} onChange={(e) => this.setState({spinnerR: e.value})}/>
                    </tr>
                    <tr>
                        <Button id="pointButton" label="Проверить" /*onClick="/checkPoint/save"*//>
                    </tr>
                </table>
            </form>
        );
    }

}
export default InputElem;