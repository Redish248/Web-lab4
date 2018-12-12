import React from 'react';
import ReactDOM from 'react-dom';
import './styles/index.css';
import './styles/media-index.css';
import Clock from './components/clock';
import TabRegister from './components/TabRegister';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<TabRegister />, document.getElementById('login'));
ReactDOM.render(<Clock />, document.getElementById('date'));
serviceWorker.unregister();
