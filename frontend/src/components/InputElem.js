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
                <Spinner min={-5} max={3}/>

                <h3>Координата Y:</h3>

                <Slider  style={{width: '14em'}}/>

                <h3>Радиус R: </h3>
                <Spinner id="R" min={-5} max={3}/>


                <Button label="Проверить" /*onClick="/checkPoint/save"*//>
            </form>
        );
    }

}
export default InputElem;