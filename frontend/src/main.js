import React from 'react';
import ReactDOM from 'react-dom';
import * as serviceWorker from './serviceWorker';
import InputElem from "./components/InputElem";

ReactDOM.render(<InputElem />, document.getElementById('inputXYR'));
serviceWorker.unregister();