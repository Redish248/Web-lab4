import React from 'react';
import ReactDOM from 'react-dom';
import './styles/main.css';
import * as serviceWorker from './serviceWorker';
import InputElem from "./components/InputElem";
import CanvasP from "./components/CanvasP.js";

ReactDOM.render(<InputElem />, document.getElementById('inputXYR'));
ReactDOM.render(<CanvasP/>,document.getElementById('canvasPoint'));
serviceWorker.unregister();