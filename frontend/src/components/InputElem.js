import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

import {Button} from 'primereact/button';
import {Spinner} from 'primereact/spinner';
import {Slider} from 'primereact/slider';


class InputElem extends Component {
    render() {
        return (
            <form method="post" action="/checkPoint">
                <h3>Координата X:</h3>
                <Spinner /*value={this.state.value} onChange={(e) => this.setState({value: e.value})}*/ min={-5} max={3} />

                <h3>Координата Y: {this.state.val2}</h3>
                <InputText value={this.state.val2} style={{width: '14em'}} type="number" onChange={this.onChangeSlider2} />
                <Slider value={this.state.val2} onChange={this.onChangeSlider2} style={{width: '14em'}} />

                <h3>Радиус R:</h3>
                <Spinner /*value={this.state.value} onChange={(e) => this.setState({value: e.value})}*/ min={-5} max={3} />


                <Button label="Проверить" onclick="/checkPoint/save" />
            </form>
        );
    }

onChangeSlider2(e) {
    var newValue;
    if (e.target && e.target.nodeName === "INPUT") {
        newValue = e.target.value;
    }
    else {
        newValue = e.value;
    }

    this.setState({ val2: newValue });
}
}


export default InputElem;